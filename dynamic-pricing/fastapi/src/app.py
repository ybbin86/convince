from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from src.router.newprice_router import router as newprice_router
from src.router.dynamic_pricing_router import router as dynamic_pricing_router

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


@app.get("/")
async def root():
	return { "message" : "hi" }