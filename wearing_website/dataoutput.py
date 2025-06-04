from jinja2 import Template

data = [
    {"name": "Alice", "age": 25},
    {"name": "Bob", "age": 30}
]

template = Template('''
<html>
<head><title>People</title></head>
<body>
  <h1>Selected People</h1>
  <table border="1" class="dataframe" style="font-size:30px;">
    <thead>
        <tr style="text-align: right;">
        <th>name</th>
        <th>age</th>
        <th>edit</th>
        </tr>
    </thead>
    <tbody>
        {% for person in people %}
        <tr>
        <td>{{ person.name }}</td>
        <td>{{ person.age }}</td>
        <td><input type="button" value="edit"></td>
        </tr>
        {% endfor %}
    </tbody>
  </table>
</body>
</html>
''')

html = template.render(people=data)

# HTMLとして保存
with open('people.html', 'w', encoding='utf-8') as f:
    f.write(html)
