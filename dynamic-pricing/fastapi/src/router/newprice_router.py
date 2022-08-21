from fastapi import APIRouter, Request, Response, status

from src.core.utils import load_model, load_transform
from src.models.price_model import NewPrice

import pandas as pd

router = APIRouter(prefix='/new_price')

@router.post('/predict')
async def predict_price(payload: NewPrice, request: Request) -> dict:
    transformer = load_transform()
    model = load_model()

    data = [[
        payload.max_margin*payload.cost + payload.cost, 
        payload.min_margin*payload.cost + payload.cost,
        0.25,
        payload.category,
        payload.cost]]
    x_test = pd.DataFrame(data, columns=['최고가격', '최저가격', '계절지수', '카테고리', '원가'])
    x_test = transformer.transform(x_test)
    predict = model.predict(x_test)[0]

    if predict < payload.min_margin*payload.cost + payload.cost:
        predict = payload.min_margin*payload.cost + payload.cost
    elif predict > payload.max_margin*payload.cost + payload.cost:
        predict = payload.max_margin*payload.cost + payload.cost

    return {'price': int(round(predict, -2))}



    