import requests
import json
from faker import Faker

fake = Faker()

url = "http://localhost:8080/users"
headers = {'Content-Type': 'application/json'}

n = int(input("Nhập số lượng request: "))

for i in range(n):
    payload = {
        "firstName": fake.first_name(),
        "lastName": fake.last_name(),
        "email": fake.email(),
        "password": fake.password(length=10)  # Độ dài mật khẩu là 10 ký tự
    }

    response = requests.post(url, headers=headers, data=json.dumps(payload))

    if response.status_code == 200:
        print(f'POST request {i+1} thành công')
    else:
        print(f'Lỗi trong POST request {i+1}: {response.text}')
