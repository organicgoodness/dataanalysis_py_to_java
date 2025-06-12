# java_run.py
import json

import io
import sys

data = [
    {"name": "Alice", "age": 25, "title": "Nice to meet you!"},
    {"name": "Bob", "age": 30, "title": "Nice to meet you!"}
]
def main():
    result = {
        "name": "Mike",
        "age": 5,
        "title": "Nice to meet you!"
    }
    data.append(result)

    #data_dict = {i: item for i ,item in enumerate(data)}

    file_path = "data_content.json"
    with open(file_path, "w") as f:
        json.dump(data, f, indent=4, ensure_ascii=False)


if __name__ == "__main__":
    main()