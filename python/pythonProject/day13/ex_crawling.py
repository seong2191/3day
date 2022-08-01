import os
import selenium.webdriver as webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
import time
import urllib.request
import splitfolders
# pip install split-folders
# console 확인 navigator.userAgent
chrome_options = webdriver.ChromeOptions()
chrome_options.add_argument('user-agent=' +
    'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36')
chrome_options.add_argument("headless")
url = 'https://www.google.com/search?q='
root = './dataset/'
# 저장될 폴더 체크
if not os.path.exists(root):
    os.mkdir(root)

def fn_get_image(keyword):
    driver = webdriver.Chrome('./chromedriver',service=Service(ChromeDriverManager().install()), options=chrome_options)

    driver.implicitly_wait(3)
    driver.get(url + keyword)
    driver.implicitly_wait(2)
    driver.find_element(By.XPATH,'//*[@id="hdtb-msb"]/div[1]/div/div[2]/a').click()
    body = driver.find_element(By.TAG_NAME,'body')
    scroll_height = driver.execute_script('return document.body.scrollHeight') # 페이지 하단 창 높이
    while True:
        driver.execute_script("window.scrollTo(0, document.body.scrollHeight);") #scroll down
        time.sleep(1)
        new_scroll_height = driver.execute_script('return document.body.scrollHeight')
        if scroll_height == new_scroll_height:
            print('같음')
            button = driver.find_element(By.CLASS_NAME,'mye4qd')
            if button:
                try:
                    button.click()
                except Exception as e:
                    print(str(e))
                    break
            else:
                break
        scroll_height = new_scroll_height
    img = body.find_elements(By.TAG_NAME,'img')
    img_set = set()
    for v in img:
        try:
            if v.get_attribute('src') != None:
                print(v.get_attribute('src'))
                img_set.add(v.get_attribute('src'))
        except Exception as e:
            print(str(e))
    driver.close()
    for i, down_image in enumerate(img_set):
        urllib.request.urlretrieve(down_image, root + keyword + '/' + keyword + '_' + str(i) + '.png')
    # 이미지 다운로드
keywords = ['레반도프스키','그나브리']
for keyword in keywords:
    if not os.path.exists(root + keyword):
        os.mkdir(root + keyword)
    fn_get_image(keyword)
splitfolders.ratio(root, output='split_dataset', seed=1337, ratio=(.8, .0, .2)) # train 80% validation 0% test20%