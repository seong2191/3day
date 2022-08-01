# 가변길이 파라미터
# 함수의 입력 파라미터의 갯수를 0 ~ n 개로 받을 수 있다.
def fn_total(*num):
    tot = 0
    for n in num:
        tot += n
    return tot

def fn_sum_mul(flag, *args):

    if flag == 'sum':
        result= 0
        for i in args:
            result = result + i
    elif flag == 'mul':
        result = 1
        for i in args:
            result = result * i
    return result
print(fn_sum_mul('sum', 2, 4, 5))
print(fn_sum_mul('mul', 2, 4, 5))
print(fn_sum_mul())

# fn_lotto 함수 생성
# 매개변수로 수량을 입력 받아 수량 만큼 생성하여
# 1개의 변수에 담아 리턴


        # print(fn_total(1, 1, 2))
# print(fn_total(1, 1, 2, 5, 6, 6))
# print(fn_total())