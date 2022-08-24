import os
from dotenv import load_dotenv

env_file = f'.{os.getenv("DOT_ENV", "local")}.env'
load_dotenv(env_file)

class Settings:
    DB_PASSWORD : str = os.getenv("DB_PASSWORD")
    DB_USER : str = os.getenv("DB_USER")
    CONVINCE_HOME : str = os.getenv("CONVINCE_HOME")


settings = Settings()