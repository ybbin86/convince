from fastapi import APIRouter, Request, Response, status

from src.service.utils import load_model, load_transform
from src.models.price_model import NewPrice
from src.database.connect import conn

import pandas as pd

router = APIRouter(prefix='/new_price')

@router.post('/predict')
async def predict_price(payload: NewPrice, request: Request) -> dict:
    transformer = load_transform('/home/ubuntu/yb/src/service/transformer.pkl')
    model = load_model('/home/ubuntu/yb/src/service/new_price.pkl')

    # cur = conn.cursor()
    # cur.execute('select ')
    data = [[
        payload.margin_max*0.01*payload.cost + payload.cost, 
        payload.margin_min*0.01*payload.cost + payload.cost,
        0.25,       #수정해야함
        '사과',     #수정해야함
        payload.cost]]
    x_test = pd.DataFrame(data, columns=['최고가격', '최저가격', '계절지수', '카테고리', '원가'])
    x_test = transformer.transform(x_test)
    predict = model.predict(x_test)[0]

    if predict < payload.margin_min*0.01*payload.cost + payload.cost:
        predict = payload.margin_min*0.01*payload.cost + payload.cost
    elif predict > payload.margin_max*0.01*payload.cost + payload.cost:
        predict = payload.margin_max*0.01*payload.cost + payload.cost

    return {'price': int(round(predict, -2))}



    