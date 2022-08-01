from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service
import time
import os
import urllib.request

keyword = input("검색어를 입력하세요: ")
count = int(input("저장할 이미지의 수량을 입력하세요: "))

chrome_options = webdriver.ChromeOptions()
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=chrome_options)
driver.get("https://www.google.co.kr/imghp?hl=ko&tab=wi&authuser=0&ogbl")

elem = driver.find_element("name", "q")
elem.send_keys(keyword)
elem.send_keys(Keys.RETURN)

SCROLL_PAUSE_TIME = 1
# Get scroll height
last_height = driver.execute_script("return document.body.scrollHeight")
while True:
    # Scroll down to bottom
    driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
    # Wait to load page
    time.sleep(SCROLL_PAUSE_TIME)
    # Calculate new scroll height and compare with last scroll height
    new_height = driver.execute_script("return document.body.scrollHeight")
    if new_height == last_height:
        try:
            driver.find_element(By.CSS_SELECTOR, ".mye4qd").click()
        except:
            break
    last_height = new_height

images = driver.find_elements(By.CSS_SELECTOR, ".rg_i.Q4LuWd")

try:
    os.mkdir("bayern/train")
except:
    pass


try:
    os.mkdir("bayern/train/" +keyword)
except:
    pass

num = 1

for image in images:

    try:
        # image.click()
        driver.execute_script("arguments[0].click();", image)
        time.sleep(2)
        imgUrl = driver.find_element(By.XPATH,
                                     '//*[@id="Sva75c"]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div[3]/div/a/img').get_attribute(
            "src")
        opener = urllib.request.build_opener()
        opener.addheaders = [('User-Agent',
                              'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1941.0 Safari/537.36')]
        urllib.request.install_opener(opener)
        urllib.request.urlretrieve(imgUrl, "./bayern/train/" + keyword + "/" + str(num) + ".jpg")
        print("./" + keyword + "/" + str(num) + ".jpg" + " 저장완료")
        num = num + 1
    except:
        print("문제가 발생하였습니다.")
        pass

    if num > count:
        print("크롤링을 종료합니다.")
        break

driver.close()