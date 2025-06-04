# java_run.py
import json

import io
import sys


def main():
    result = {
        "name": "Mike",
        "age": 5,
        "title": "Nice to meet you!"
    }
    #data.append(result)
    with open("../data_content.json", "w") as f:
        json.dump(result, f)
    

if __name__ == "__main__":
    main()