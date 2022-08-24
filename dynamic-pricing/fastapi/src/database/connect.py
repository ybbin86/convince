import pymysql
from src.core.config import settings

conn = pymysql.connect(host='3.37.92.138', user=settings.DB_USER, password=settings.DB_PASSWORD,
                       db='kurly', charset='utf8')
