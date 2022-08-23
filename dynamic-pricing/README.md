# 적정가 예측 및 Dynamic Pricing Repo

* airflow : dynamic pricing job scheduler
* fastapi : ML API
* model : Training
* raw_data : data preprocessing

## 구조
```
├── README.md
├── airflow
│   ├── README.md
│   ├── airflow.cfg
│   ├── airflow.db
│   ├── dags
│   │   └── dynamic_pricing.py
│   ├── logs
│   │   ├── dag_processor_manager
│   │   └── scheduler
│   │       ├── 2022-08-21
│   │       │   └── native_dags
│   │       │       └── example_dags
│   │       │           ├── plugins
│   │       │           └── subdags
│   │       └── latest -> /home/ubuntu/airflow/logs/scheduler/2022-08-21
│   └── webserver_config.py
├── data_preprocessing
│   ├── brazilian_ecommerce.ipynb
│   ├── data
│   │   ├── Untitled.ipynb
│   │   ├── apple.csv
│   │   ├── cabbage.csv
│   │   ├── customer_product_purchase.csv
│   │   ├── grape.csv
│   │   ├── pear.csv
│   │   ├── repurchase.csv
│   │   ├── season_point.csv
│   │   ├── train_dynamic.csv
│   │   ├── water_melon.csv
│   │   ├── whole_sale_price.csv
│   │   ├── whole_sale_price_1.csv
│   │   └── whole_sale_price_2.csv
│   ├── get_whole_sale.ipynb
│   ├── preprocessing_apple.ipynb
│   ├── preprocessing_cabbage.ipynb
│   ├── preprocessing_grape.ipynb
│   ├── preprocessing_pear.ipynb
│   ├── preprocessing_water_melon.ipynb
│   └── seasonal_point.ipynb
├── fastapi
│   ├── Dockerfile
│   ├── README.md
│   ├── requirements.txt
│   └── src
│       ├── app.py
│       ├── core
│       │   └── __init__.py
│       ├── database
│       │   ├── __init__.py
│       │   └── connect.py
│       ├── middleware
│       │   └── __init__.py
│       ├── models
│       │   ├── __init__.py
│       │   └── price_model.py
│       ├── router
│       │   ├── __init__.py
│       │   ├── dynamic_pricing_router.py
│       │   └── newprice_router.py
│       └── service
│           ├── __init__.py
│           ├── model_dynamic_pricing.pkl
│           ├── new_price.pkl
│           ├── preprocessing.py
│           ├── transformer.pkl
│           ├── transformer_dynamic_pricing.pkl
│           └── utils.py
├── model
│   ├── README.md
│   └── RandomForest
│       ├── RandomForest_dynamic.ipynb
│       ├── RandomForest_new_price.ipynb
│       ├── Untitled.ipynb
│       ├── minmax_scaler.pkl
│       ├── model_dynamic_price.pkl
│       ├── model_dynamic_pricing.pkl
│       ├── new_price.pkl
│       ├── test.save
│       ├── transformer.pkl
│       └── transformer_dynamic_pricing.pkl
└── raw_data
    ├── Bas_GarakPrice_apple.csv
    ├── Bas_GarakPrice_cabbage.csv
    ├── Bas_GarakPrice_grape.csv
    ├── Bas_GarakPrice_pear.csv
    ├── Bas_GarakPrice_waterMelon.csv
    ├── README.md
    └── whole_sale_price.csv
```