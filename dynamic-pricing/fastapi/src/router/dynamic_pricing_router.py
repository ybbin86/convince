from fastapi import APIRouter, Request, Response, status

from src.database.connect import conn
from src.service.utils import load_model, load_transform

import pandas as pd
import logging
from datetime import datetime
import random

router = APIRouter(prefix='/dynamic_pricing')

@router.get('/update')
async def predict_price(request: Request) -> dict:
    transformer = load_transform('/home/ubuntu/yb/src/service/transformer_dynamic_pricing.pkl')
    model = load_transform('/home/ubuntu/yb/src/service/model_dynamic_pricing.pkl')
    cur = conn.cursor()
    cur.execute("SELECT * FROM goods where dynamic_pricing=1 ")
    goods = cur.fetchall()

    update_price = []

    for data in goods:
        '''
        cost : 원가
        margin_max : 최대 마진
        margin_min : 최소 마진
        category_id : 카테고리 아이디
        requchase : 재구매율
        tag : 태그 점수
        '''
        x_test = [[data[3], data[7]*0.01, data[8]*0.01, data[12], 0.6, random.uniform(1.8, 0.4), 4]]
        x_test = pd.DataFrame(x_test, columns=['cost', 'margin_max', 'margin_min', 'category_id', 'requrchase','qurchase', 'tag'])
        x_test = transformer.transform(x_test)
        price = round(model.predict(x_test)[0],-2)
        
        update_price.append({'id':data[0], 'price':round(model.predict(x_test)[0],-2)})

    update_sql = 'update goods set price=%s where id=%s'
    for data in update_price:
        cur.execute(update_sql,(data['price'], data['id']))
    conn.commit()

    cur.execute('select * from goods')
    updated_goods = cur.fetchall()
    price_history_sql = 'insert into price_history (created_time, price, goods_id) value (%s, %s, %s)'
    for data in updated_goods:
        cur.execute(price_history_sql, (datetime.now().strftime("%Y-%m-%d %H:%M:%S"),data[10], data[0]))
    conn.commit()

    return {"message" : 'success!'}