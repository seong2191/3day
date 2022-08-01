# 김성윤
from bs4 import BeautifulSoup
import requests
import day5_sqlite.mydb
db = day5_sqlite.mydb.Mydb()

url = 'https://sports.news.naver.com/wfootball/record/index?category=epl&year=2021&tab=player'
resp = requests.get(url)

soup = BeautifulSoup(resp.content, 'html.parser', from_encoding='utf-8')
tbody = soup.select_one('#wfootballPlayerRecordBody > table > tbody')
trs = tbody.find_all('tr')
for tr in trs:
   name = tr.select('.name')[0].text
   team = tr.select('.team')[0].text
   goal = tr.select('.selected > .inner > span')[0].text
   assist = tr.select('td:nth-child(4) > .inner > span')[0].text
   atkpoint = tr.select('td:nth-child(5) > .inner > span')[0].text
   shooting = tr.select('td:nth-child(6) > .inner > span')[0].text
   foul = tr.select('td:nth-child(7) > .inner > span')[0].text
   cheese = tr.select('td:nth-child(8) > .inner > span')[0].text
   kimchi = tr.select('td:nth-child(9) > .inner > span')[0].text
   corner = tr.select('td:nth-child(10) > .inner > span')[0].text
   panalty = tr.select('td:nth-child(11) > .inner > span')[0].text
   offside = tr.select('td:nth-child(12) > .inner > span')[0].text
   hitshooting = tr.select('td:nth-child(13) > .inner > span')[0].text
   game = tr.select('td:nth-child(14) > .inner > span')[0].text
   # print(name, team, goal, assist)

def fn_sports_data():
    for j in range(1, 10):
        url = 'https://sports.news.naver.com/wfootball/record/index?category=epl&year=2021&tab=player'
        resp = requests.get(url)
        soup = BeautifulSoup(resp.content, 'html.parser', from_encoding='utf-8')
        tbody = soup.select_one('#wfootballPlayerRecordBody > table > tbody')
        trs = tbody.find_all('tr')
        sports_data = []
        for tr in trs:
            name = tr.select('.name')[0].text
            team = tr.select('.team')[0].text
            goal = tr.select('.selected > .inner > span')[0].text
            assist = tr.select('td:nth-child(4) > .inner > span')[0].text
            atkpoint = tr.select('td:nth-child(5) > .inner > span')[0].text
            shooting = tr.select('td:nth-child(6) > .inner > span')[0].text
            foul = tr.select('td:nth-child(7) > .inner > span')[0].text
            cheese = tr.select('td:nth-child(8) > .inner > span')[0].text
            kimchi = tr.select('td:nth-child(9) > .inner > span')[0].text
            corner = tr.select('td:nth-child(10) > .inner > span')[0].text
            panalty = tr.select('td:nth-child(11) > .inner > span')[0].text
            offside = tr.select('td:nth-child(12) > .inner > span')[0].text
            hitshooting = tr.select('td:nth-child(13) > .inner > span')[0].text
            game = tr.select('td:nth-child(14) > .inner > span')[0].text
            sports_data.append([name, team, goal, assist, atkpoint, shooting, foul,
                                cheese, kimchi, corner, panalty, offside, hitshooting, game])
    for i in sports_data:
        insert_sql = """
                    INSERT INTO sports(
                    pl_name, pl_team, goal, assist, atkpoint, shooting, foul, cheese, 
                    kimchi, corner, panalty, offside, hitshooting, game)
                    VALUES (
                    :1, :2, :3, :4, :5, :6, :7, :8, :9, :10, :11, :12, :13, :14)
                    """
        cnt = db.fn_insert(insert_sql,i)
        print(cnt)
fn_sports_data()