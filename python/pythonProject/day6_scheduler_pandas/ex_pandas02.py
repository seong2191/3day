import pandas as pd
# dict to Dataframe
user = {
    "name":["Tom", "Tyrell", "Claire"]
    ,"age":[60, 25, 30]
}
df_user_age = pd.DataFrame(user)
print(df_user_age.head())
df_user_height = pd.DataFrame({
    "name":["Tom", "Tyrell", "Claire"]
    ,"height":[6.2, 4.0, 5.5]
})

#join
joined = df_user_age.set_index("name").join(df_user_height.set_index('name'))
print(joined.head())
joined = joined.reset_index()

# 컬럼추가
joined['gender'] = ['M', 'M', 'F']
print(joined.head())

# 그룹바이 기능(내장 함수 이외의 apply 함수를 통해 함수를 적용 할 수 있음)
print('평균', joined.groupby('gender').mean())