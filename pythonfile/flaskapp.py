from flask import Flask, render_template
import sqlite3

app = Flask(__name__)

def get_data():
    # データベースに接続（なければ作成される）
    conn = sqlite3.connect('database.db')
    cursor = conn.cursor()

    # usersテーブルを作成
    cursor.execute('''
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        age INT NOT NULL,
        English_word TEXT
    )
    ''')

    # 初期データの挿入
    users = [
        ('Alice', 17 ,'accomplish'),
        ('Mike', 15 ,'complete'),
        ('Charles', 16 ,'perfect')
    ]

    cursor.executemany('INSERT INTO users (name, age, English_word) VALUES (?, ?, ?)', users)

    # コミットして接続を閉じる
    conn.commit()
    conn.close()

    print("データベースの初期化が完了しました。")

    return users

@app.route('/')
def index():
    users = get_data()
    return render_template('flasksql.html', users=users)

if __name__ == '__main__':
    app.run(debug=True)
