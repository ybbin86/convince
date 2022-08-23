# FastAPI
**납뜩이**팀 서비스의 ML관련 API

## 기능
* 적정가 예측 : 새로운 상품 등록시 적정가 예측
* dynamic pricing : 1시간 단위 동적 가격 변경

## FastAPI 실행 방법

```shell
uvicorn src.app:app --host 0.0.0.0 --port 8000 --reload
```

## Docker 빌드&실행

```shell
docker build --tag fastapi:0.0 .
docker run -it -p 8001:8001 fastapi:0.0
```