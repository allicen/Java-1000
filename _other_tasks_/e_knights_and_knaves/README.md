<h1 class="title">E. Рыцари и лжецы</h1>
<p><b>Время: 1 сек.<br>Память: 64 Мб</b></p>
<p>На острове живут n человек. Каждый из них либо рыцарь, либо лжец. Все рыцари всегда говорят правду, все лжецы всегда лгут. Каждый человек сделал по одному утверждению. i-тый островитянин (1 ≤ i ≤ n) сказал: "Среди всех людей на острове не более k<sub>i</sub> рыцарей".</p>
<p>По заданным утверждениям островитян найдите любое возможное количество рыцарей на острове или определите, что такая ситуация невозможна.</p>
<h2>Формат ввода</h2>
<p>Первая строка входных данных содержит одно целое число n (1 ≤ i ≤ 1000) — количество жителей острова.</p>
<p>Во второй строке задаются n целых чисел k<sub>i</sub> (1 ≤ k<sub>i</sub> ≤ n), разделенных пробелом.</p>
<h2>Формат вывода</h2>
<p>Если описанная ситуация невозможна, то выведите −1. Иначе выведите одно целое число — количество рыцарей, живущих на острове. Если есть несколько возможных ответов, разрешается вывести любой из них.</p>
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
        <td>2<br>
            2 2</td>
        <td>2</td>
     </tr>
     <tr>
        <td>4<br>
            0 1 2 3</td>
        <td>2</td>
     </tr>
  </tbody>
</table>