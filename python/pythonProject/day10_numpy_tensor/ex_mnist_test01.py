import os.path
import sys

import keras.models
from keras.datasets import mnist
from keras.utils import np_utils
import tensorflow as tf
from keras.models import Sequential
from keras.layers import Dense

# seed 값 설정 (똑같은 랜덤 값 나오도록)
tf.random.set_seed(0)
(x_train, y_train), (x_test, y_test) = mnist.load_data()
import matplotlib.pyplot as plt
# 학습을 위해 데이터 구조 변형
x_train = x_train.reshape(x_train.shape[0], 784).astype('float32') / 255
x_test = x_test.reshape(x_test.shape[0], 784).astype('float32') / 255
y_train = np_utils.to_categorical(y_train)
y_test = np_utils.to_categorical(y_test)
# 모델 불러 오기
model = keras.models.load_model('./model/09-0.0599.hdf5')
model.summary()
plt.imshow(x_test[:1].reshape(28, 28))
plt.show()
pred = model.predict(x_test[:1])
print(pred)
import numpy as np
print(np.argmax(pred, 1))