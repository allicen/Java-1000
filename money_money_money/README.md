<h1 class="title">Money, money, money (31%)</h1>
<p><a href="https://acmp.ru/index.asp?main=task&id_task=751">Ссылка на задачу</a></p>
<p><b>Время: 1 сек.<br>Память: 16 Мб<br>Сложность: 31%</b></p>
<p>Правительство Флатландии решило провести реформу денежной системы. Цель реформы – радикально уменьшить число банкнот в обращении, в результате их должно остаться ровно две. Таким образом, после реформы во Флатландии будут циркулировать банкноты достоинством a тугриков и b тугриков, где a и b поручено выбрать министерству финансов.</p>
<p>Одна из проблем заключается в том, что президент Флатландии ненавидит число x. Поэтому министр финансов решил, что выберет такие a и b, что нельзя будет заплатить ровно x тугриков без сдачи. С другой стороны, для любой суммы большей x должна быть возможность заплатить ее без сдачи.</p>
<p>Итак, вам поручено выбрать соответствующие a и b.</p>
<h2>Формат ввода</h2>
<p class=text>
Входной файл INPUT.TXT содержит натуральное число x, не превосходящее 10<sup>12</sup>.
</p>
<h2>Формат вывода</h2>
<p class=text>
В выходной файл OUTPUT.TXT выведите два целых числа a и b такие, что сумму в x тугриков нельзя заплатить банкнотами в a и b тугриков без сдачи, а любую большую сумму – можно. Если решения не существует, выведите в выходной файл два нуля.
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
        <td>3</td>
        <td>2 5</td>
     </tr>
     <tr>
         <td>4</td>
         <td>0 0</td>
     </tr>
     <tr>
         <td>5</td>
         <td>3 4</td>
     </tr>
  </tbody>
</table>