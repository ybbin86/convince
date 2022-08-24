from datetime import timedelta 
import requests

from airflow import DAG 
from airflow.utils.dates import days_ago
from airflow.operators.bash import BashOperator 
from airflow.operators.python import PythonOperator

def send_query() -> None:
    url = 'http://3.37.92.138:8001/dynamic_pricing/update'
    response = requests.get(url)

    if response.status_code==404:
        raise Exception('응답없음')

def print_success():
    return "success"

with DAG(
    dag_id="dynamic_pricing",
    description = "1시간 간격으로 모델 호출 -> DB 업데이트", 
    start_date=days_ago(1),
    schedule_interval= "@hourly",
    tags=["dynamic_pricing"],
)as dag:
    t1 = PythonOperator(
        task_id = "send_query",
        python_callable=send_query,
        depends_on_past= True,
        owner="yb",
        retries = 3,
    )
    t2 = PythonOperator(
        task_id = "print_world",
        python_callable=print_success,
        depends_on_past= True,
        owner="yb",
        retries = 3,
    )

    t1 >> t2