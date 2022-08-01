import requests
import json
# 코인 코드 정보
# https://api.upbit.com/v1/market/all

# 코인 정보
# https://api.upbit.com/v1/ticker?markets=KRW-BTC
coin_info_url ='https://api.upbit.com/v1/market/all'
coin_detail = 'https://api.upbit.com/v1/ticker?markets='
info = requests.get(coin_info_url)
coins = json.loads(info.text)
print(coins)

for row in coins:
    # print(row['market'], row['korean_name'], row['english_name'])
    detail_info = requests.get(coin_detail + row['market'])
    if detail_info.status_code == 200:
        now_coin = json.loads(detail_info.text)
        # print(now_coin)
        print(row['korean_name'], now_coin[0]['trade_price'])
