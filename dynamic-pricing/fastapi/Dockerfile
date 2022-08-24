FROM python:latest

RUN apt-get update && \
    pip install --upgrade pip

WORKDIR /app
COPY . .

ENV DOT_ENV="development"
RUN pip install -r requirements.txt
ENV PORT="8001"

CMD ["sh", "-c",  "uvicorn src.app:app --host 0.0.0.0 --port ${PORT} --reload"]