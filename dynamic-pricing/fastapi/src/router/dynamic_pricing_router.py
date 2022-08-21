from fastapi import APIRouter, Request, Response, status

from src.database.connect import conn

import pandas as pd

router = APIRouter(prefix='/dynamic_pricing')

@router.get('/update')
async def predict_price(request: Request) -> dict:
    cur = conn.cursor()
    cur.execute("SELECT * FROM goods_tag_map")
    rows = cur.fetchall()

    return {"message" : rows}