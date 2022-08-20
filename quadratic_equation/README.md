<h1 class="title">Квадратное уравнение (28%)</h1>
<p><b>Время: 1 сек.<br>Память: 16 Мб<br>Сложность: 28%</b></p>
<p>Сложно найти человека, который любит решать однообразные задачки по математике. В последнее время школьникам стало легче, ведь с появлением компьютеров почти в каждой квартире стало существенно проще проверять себя.</p>
<p>Но программы, в которых решение уравнений является стандартной функцией, установлены не везде. Напишите программу, которая сможет решить уравнение ax<sup>2</sup> + bx + c = 0 при заданных коэффициентах a, b и c.</p>
<h2>Формат ввода</h2>
<p>Единственная строка входного файла input.txt содержит три целых числа a, b и c, каждое из которых не превосходит по модулю 30000. Числа разделяются пробелами.</p>
<h2>Формат вывода</h2>
<p>На первой строке выходного файла output.txt выведите число различных действительных корней заданного уравнения. Затем выведите сами корни по одному на строке с ошибкой, не превосходящей 10<sup>-4</sup>. Если для заданных коэффициентов корней бесконечно много, на единственной строке выходного файла выведите -1.</p>
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
        <td>1 -3 2</td>
        <td>2<br>
            1.000000<br>
            2.000000</td>
     </tr>
     <tr>
         <td>0 -1 6</td>
         <td>1<br>
             6.000000</td>
     </tr>
  </tbody>
</table>