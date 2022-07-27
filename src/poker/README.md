<h1 class="title">Покер (33%)</h1>
<p><a href="https://acmp.ru/index.asp?main=task&id_task=347" target="_blank">Ссылка на задачу</a></p>
<p><b>Время: 1 сек.<br>Память: 16 Мб<br>Сложность: 33%</b></p>
<p>Имеется 5 целых чисел. Среди них:</p>
<ul>
<li>если одинаковы 5, то вывести "Impossible", иначе</li>
<li>если одинаковы 4, то вывести "Four of a Kind", иначе</li>
<li>если одинаковы 3 и 2, то вывести "Full House", иначе</li>
<li>если есть 5 последовательных, то вывести "Straight", иначе</li>
<li>если одинаковы 3, то вывести "Three of a Kind", иначе</li>
<li>если одинаковы 2 и 2, то вывести "Two Pairs", иначе</li>
<li>если одинаковы 2, то вывести "One Pair", иначе</li>
<li>вывести "Nothing".</li>
</ul>
<h2>Формат ввода</h2>
<p class=text>
Входной файл INPUT.TXT содержит 5 целых чисел от 1 до 13, разделенных пробелом.
</p>
<h2>Формат вывода</h2>
<p class=text>
В выходной файл OUTPUT.TXT следует вывести результат анализа.
</p>
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
        <td>1 3 9 3 2</td>
        <td>One Pair</td>
     </tr>
     <tr>
         <td>1 5 5 4 4</td>
         <td>Two Pairs</td>
      </tr>
      <tr>
          <td>1 5 2 4 3</td>
          <td>Straight</td>
       </tr>
       <tr>
          <td>10 11 12 13 1</td>
          <td>Nothing</td>
       </tr>
  </tbody>
</table>