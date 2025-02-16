# 피마 인디언 데이터 (당뇨병 예측)
# 임신횟수, 포도당 수치, 혈압, 피부두께, 인슐린, BMI, 당뇨병가족력, 나이,
# 당뇨병 여부 (0 : 아님, 1 : 당뇨) <- 종속 변수 이항 분류
import pandas as pd
from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()
df = pd.read_csv('../day8_regression/datasets/pima-indians-diabetes.csv')
print(df.info())
x = df.iloc[:, 0:8] # : <- 의미는 전체 행 | 뒤에는 열 (0~8열까지)
y = df.iloc[:, 8] # 8열만
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
train_x, test_x, train_y, test_y = train_test_split(x, y, test_size=0.2)
model = LogisticRegression(max_iter=5000) # 5000번 학습
train_x = scaler.fit_transform(train_x)
test_x = scaler.fit_transform(test_x)
model.fit(train_x, train_y.values.ravel())
print(model.coef_)          # 기울기
print(model.intercept_)     # y절편

print('학습데이터 성능:', model.score(train_x, train_y))
print('테스트데이터 성능:', model.score(test_x, test_y))
