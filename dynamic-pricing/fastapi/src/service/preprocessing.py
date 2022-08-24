import pandas as pd
import math

def get_tag_score(order_data, tag_data, goods_tag_data):
    df_tag = pd.DataFrame(tag_data, columns=['id', 'c_time', 'u_time', 'end_date', 'name', 'start_date'])
    df_order = pd.DataFrame(order_data, columns=['id', 'c_time', 'margin', 'price', 'u_t', 'g_id', 'u_id'])
    df_goods_tag = pd.DataFrame(goods_tag_data, columns=['id', 'c_time', 'u_time', 'goods_id', 'tag_id'])
    df_order['c_time'] = pd.to_datetime(df_order['c_time'])
    df_tag['end_date'] = pd.to_datetime(df_tag['end_date'])
    df_tag['start_date'] = pd.to_datetime(df_tag['start_date'])

    tag_score_list = []

    for i in range(len(df_tag)):
        item_score = 0
        item_list = df_goods_tag[df_goods_tag['tag_id']==df_tag.iloc[i]['id']].tolist()
        for item in item_list:
            annual_avg_sales = df_order[df_order['g_id']==item]['price'].sum() / 365
            df_event = df_order[(df_order['c_time']>df_tag.iloc[i]['start_date']) & (df_order['c_time']>df_tag.iloc[i]['start_date'])]
            event_avg_sales = df_event[df_event['g_id']==item] / len(df_event)
            item_score += math.log(event_avg_sales/annual_avg_sales)
        tag_score_list.append(item_score)
    
    return tag_score_list

    