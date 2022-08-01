# 그래프 기능 라이브러리
import matplotlib.pyplot as plt
import FinanceDataReader as fdr
import pandas as pd
# pip install matplotlib

# samsung_all = fdr.DataReader('005930')
# samsung_all['Close'].plot()
TSLA = fdr.DataReader('TSLA')
TSLA['Close'].plot()
plt.show()