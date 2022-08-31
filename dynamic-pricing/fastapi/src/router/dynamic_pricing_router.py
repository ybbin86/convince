'''
Dynamic pricing API
Airflow를 통해 batch 간격으로 호출
'''
from fastapi import APIRouter, Request, Response, status

from src.database.connect import conn
from src.service.utils import load_model, load_transform
from src.core.config import settings

import pandas as pd
import logging
from datetime import datetime
import random
import os

router = APIRouter(prefix='/dynamic_pricing')

@router.get('/update')
async def predict_price(request: Request) -> dict:
    momentum = 0.7
    eta = 0.3
    now = datetime.now()

    transformer = load_transform(os.path.join(settings.CONVINCE_HOME,'src','service','transformer_dynamic_pricing.pkl'))     # 전처리 transform load
    model = load_model(os.path.join(settings.CONVINCE_HOME,'src','service','model_dynamic_pricing.pkl'))                 # 모델 load
    
    # 상품 중 토글 활성화 된 상품 데이터 가져옴
    cur = conn.cursor()
    cur.execute("select * from goods where dynamic_pricing=1 ")
    goods = cur.fetchall()
    # cur.execute('select * from goods_tag_map where')
    # tag = list(cur.fetchall())

    update_price = []
    df_tag = pd.DataFrame(tag, columns=['id', 'c_time', 'u_time', 'g_id', 't_id'])
    
    # 실시간 가격 예측
    for data in goods:
        '''
        cost : 원가
        margin_max : 최대 마진
        margin_min : 최소 마진
        category_id : 카테고리 아이디
        repuchase : 재구매율(데이터가 없어 random 값 입력)
        purchase : 구매전환율(데이터가 없어 random 값 입력)
        tag : 태그 점수(데이터가 없어 random 값 입력)
        '''
        # tag_score = df_tag[df_tag['g_id']==data[0]]['t_id'].sum()
        tag_score = random.uniform(0, 5.0)
        x_test = [[data[3], data[7]*0.01, data[8]*0.01, data[12], random.uniform(0.6, 0.2), random.uniform(1.8, 0.4), tag_score]]
        x_test = pd.DataFrame(x_test, columns=['cost', 'margin_max', 'margin_min', 'category_id', 'requrchase','qurchase', 'tag'])
        x_test = transformer.transform(x_test)
        predict = round(model.predict(x_test)[0],-2)

        # cur.execute('select price from price_history order by id desc limit 2 ')
        # before_price = cur.fetchall()

        # momentum 적용
        if now.hour >= 23 and now.hour < 5:
            v = before_price[0][0] - before_price[1][0]
            v = momentum*v + eta*(before_price[0][0]-predict)
            price = data[10] + v
        else:
            price = predict
        
        update_price.append({'id':data[0], 'price':price})

    # 예측 가격 업데이트
    update_sql = 'update goods set price=%s where id=%s'
    for data in update_price:
        cur.execute(update_sql,(data['price'], data['id']))
    conn.commit()

    # price history 테이블 업데이트
    cur.execute('select * from goods')
    updated_goods = cur.fetchall()
    price_history_sql = 'insert into price_history (created_time, price, goods_id) value (%s, %s, %s)'
    for data in updated_goods:
        cur.execute(price_history_sql, (now.strftime("%Y-%m-%d %H:%M:%S"),data[10], data[0]))
    conn.commit()

    return {"message" : 'success!'}