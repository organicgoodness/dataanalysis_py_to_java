FROM python:3.10-slim

WORKDIR /app

# requirements.txt をコピーして、pip install を実行
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# アプリ本体をコピー
COPY . .

CMD ["python3", "app.py"]
