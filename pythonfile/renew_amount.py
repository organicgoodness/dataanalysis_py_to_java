import json

with open("data_content.json", "r", encoding="utf-8") as f:
    data = json.load(f)

# 例: Aliceの年齢を30に更新
for person in data:
    if person["name"] == "Alice":
        person["age"] = 29

with open("data_content.json", "w", encoding="utf-8") as f:
    json.dump(data, f, indent=2, ensure_ascii=False)
