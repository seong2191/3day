# 페이지에 있는 영화 포스터 이미지를 movie_poster 폴더에 저장하시오
# -*- coding:utf-8 -*-
import os

import requests
from bs4 import BeautifulSoup
from urllib import parse
import urllib.request as req

path = os.getcwd()
imgdir = path +'/img/'
if os.path.isdir(imgdir):
    print('폴더있음')
else :
    # 폴더생성
    os.mkdir(imgdir)

url = 'https://movie.naver.com/movie/running/current.naver'
resp = requests.get(url)
soup = BeautifulSoup(resp.text, 'html.parser')
ul = soup.select_one('.lst_detail_t1')
imgs = ul.find_all('img')
for img in imgs:
    title = img.get('src').split('/')[-2]
    filetype = title.split('_')[-1]
req.urlretrieve(url, imgdir + title + '.' + filetype)

