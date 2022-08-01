from PIL import Image
import matplotlib.pyplot as plt
import numpy as np
import keras
img = Image.open('./2.png').convert('L') # 'L' <-- gray 컬러로 읽어옴
print(img.width, img.height)
plt.imshow(img)
plt.show()
re_img = img.resize((28, 28))
test_data = np.array(re_img).reshape(1, 784).astype('float32') / 255
print(test_data)
model = keras.models.load_model('./model/09-0.0599.hdf5')
pred = model.predict(test_data)
print(np.argmax(pred, 1))