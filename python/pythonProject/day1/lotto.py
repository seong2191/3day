## 오늘에 문제
### input 으로 숫자를 입력 받아 그 수량 만큼 로또번호(6개 숫자)를 출력하시오
# > 6개의 숫자에는 중복이 허용되지 않으며 1 ~ 45의 수를 가진다.
# > ex) 6 < 입력   {1, 2, 3, 4, 5, 6}, {1, 45, 3, 4, 5, 6}....
### while, for, set, len, input.. 등 사용

#  1.입력 받은 수 만큼 for
#  2.for문 돌때마다 랜덤숫자 6개 만들어서 출력
#                 랜덤숫자 6개<-- 고정적인 수량 중복 허용 안함 set을 이용 하면 편함
#                  set자료 구조로 6자리가 될때까지 random 함수 사용하여 숫자 생성
import random
# ran = random.randint(1, 10)
# 1
num = int(input('로또 수량을 입력하세요:'))
for i in range(num):
    lotto_num = set()
    while len(lotto_num) < 6:
        lotto_num.add(random.randint(1, 45))
    print(lotto_num)




