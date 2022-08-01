
# 함수
def fn_name(param):
    return param * 10

print(fn_name('hi'))

def fn_name2(param):
    nm = param.split()
    return nm[0], nm[1], nm[2]

# first, last = fn_name2('팽 수')
# print('성:' , first, '이름:', last)
name = fn_name2('팽 수 다')
print(name[0], name[1])