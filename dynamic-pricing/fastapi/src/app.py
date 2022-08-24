from fastapi import FastAPI, Request
from fastapi.middleware.cors import CORSMiddleware

from src.router.newprice_router import router as newprice_router
from src.router.dynamic_pricing_router import router as dynamic_pricing_router
from src.database.connect import conn
from src.models.price_model import DynamicPricing

def create_app() -> FastAPI:
    app = FastAPI()
    app.add_middleware(
        CORSMiddleware,
        allow_origins=["*"],
        allow_credentials=True,
        allow_methods=["*"],
        allow_headers=["*"],
    )
    return app
    
app = create_app()
app.include_router(newprice_router)
app.include_router(dynamic_pricing_router)



@app.post("/dp_onoff")
async def root(payload: DynamicPricing, request: Request):
    cur = conn.cursor()
    cur.execute(f'update goods set dynamic_pricing={payload.dynamic_pricing} where id={payload.id}')
    conn.commit()

    return {'message' : 'success'}