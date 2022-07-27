<h1 class="title">Коробки (19%)</h1>
<p><b>Время: 1 сек.<br>Память: 16 Мб<br>Сложность: 19%</b></p>
<p>На столе лежат коробка размера A1 × B1 × C1 и коробка размера A2 × B2 × C2. Выясните можно ли одну из этих коробок положить в другую, если разрешены повороты коробок вокруг любого ребра на угол 90 градусов.</p>
<h2>Формат ввода</h2>
<p>Первая строка входного файла содержит три целых числа A1, B1 и C1. Вторая строка входного файла содержит три целых числа A2, B2 и C2. Все числа положительны и не превосходят 1000.</p>
<h2>Формат вывода</h2>
<p>Если коробки одинаковы, выведите "Boxes are equal". Если первая коробка может быть положена во вторую, выведите "The first box is smaller than the second one". Если вторая коробка может быть положена в первую, выведите "The first box is larger than the second one". Иначе, выведите "Boxes are incomparable".</p>
<h3>Примеры</h3>
<table class="sample-tests">
<thead>
    <tr>
        <th>Ввод</th>
        <th>Вывод</th>
    </tr>
</thead>
<tbody>
        <tr>
            <td>1 2 3<br>
                3 2 1</td>
            <td>Boxes are equal</td>
        </tr>
        <tr>
            <td>2 2 3<br>
                3 2 1</td>
            <td>The first box is larger than the second one</td>
        </tr>
        <tr>
            <td>2 2 3<br>
                3 2 3</td>
            <td>The first box is smaller than the second one</td>
        </tr>
        <tr>
            <td>3 4 5<br>
                2 4 6</td>
            <td>Boxes are incomparable</td>
        </tr>
    </tbody>
</table>

