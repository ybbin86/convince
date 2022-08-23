'''
새로운 상품 등록시 적정가 예측
'''
from unicodedata import category
from fastapi import APIRouter, Request, Response, status

from src.service.utils import load_model, load_transform
from src.models.price_model import NewPrice
from src.database.connect import conn

import pandas as pd
from datetime import date

router = APIRouter(prefix='/new_price')

mapping = {
        3 : '사과',
        9 : '배추',
        6 : '배',
        7 : '포도',
        8 : '수박'
    }

@router.post('/predict')
async def predict_price(payload: NewPrice, request: Request) -> dict:
    '''
    payload
        margin_max : 최대 마진
        margin_min : 최소 마진
        category_id : 카테고리 아이디
        cost : 원가
    '''
    transformer = load_transform('/home/ubuntu/yb/src/service/transformer.pkl')     # 전처리 transform load
    model = load_model('/home/ubuntu/yb/src/service/new_price.pkl')                 # 모델 load

    # 계절지수를 구하기 위해 현재 월 구함
    cur = conn.cursor()
    cur.execute(f'select season_point from season_point where month={date.today().month} and category_id={2}')
    row = cur.fetchall()

    data = [[
        payload.margin_max*0.01*payload.cost + payload.cost, 
        payload.margin_min*0.01*payload.cost + payload.cost,
        row[0],       
        mapping[payload.category_id], 
        payload.cost]]
    x_test = pd.DataFrame(data, columns=['최고가격', '최저가격', '계절지수', '카테고리', '원가'])
    x_test = transformer.transform(x_test)
    predict = model.predict(x_test)[0]

    # margin 상한선과 하한선을 벗어나지 않음
    if predict < payload.margin_min*0.01*payload.cost + payload.cost:
        predict = payload.margin_min*0.01*payload.cost + payload.cost
    elif predict > payload.margin_max*0.01*payload.cost + payload.cost:
        predict = payload.margin_max*0.01*payload.cost + payload.cost

    return {'price': int(round(predict, -2))}



    