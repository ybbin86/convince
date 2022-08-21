from fastapi import FastAPI

from src.router.newprice_router import router as newprice_router
from src.router.dynamic_pricing_router import router as dynamic_pricing_router
from src.database.conn import db

def create_app() -> FastAPI:
    app = FastAPI()
    # db.init_app(app)
    return app
    
app = create_app()
app.include_router(newprice_router)
app.include_router(dynamic_pricing_router)


@app.get("/")
async def root():
    
	return { "message" : metadata }