<h1 class="title">D. Игрушки</h1>
<p><b>Время: 2 сек.<br>Память: 256 Мб</b></p>
<div id="problem_text">
   <div class="problem_par">
      <div class="problem_par_normal">У Вити есть полка, на которой в ряд выставлены <i>n</i> игрушек. На каждой игрушке написано некоторое число. На позиции номер <i>i</i> стоит игрушка с числом <i>a</i><sub><i>i</i></sub>. Иначе говоря, игрушки образуют массив <i>a</i>.</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">В пятницу Витя сделает перестановку: две игрушки, находящиеся на позициях <i>i</i> и <i>j</i> (<i>i</i> ≠<i>j</i>), он поменяет местами. Витя обожает порядок, поэтому он хочет, чтобы после перестановки на чётных позициях стояли чётные числа, а на нечётных&nbsp;— нечётные. </div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">От вас требуется выяснить, можно ли из массива <i>a</i> получить массив, который удовлетворяет заданному условию, сделав ровно один обмен двух элементов, стоящих на различных позициях.</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Массив <i>a</i> индексируется с единицы.</div>
   </div>
   <h3 class="problem_subtitle">Исходные данные</h3>
   <div class="problem_par">
      <div class="problem_par_normal">В первой строке находится одно натуральное число <i>n</i> (2 ≤ <i>n</i> ≤ 1000).</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">В следующей строке находятся <i>n</i> натуральных чисел <i>a</i><sub><i>i</i></sub>&nbsp;— числа, записанные на игрушках (1 ≤ <i>a</i><sub><i>i</i></sub> ≤ 10<sup>9</sup>).</div>
   </div>
   <h3 class="problem_subtitle">Результат</h3>
   <div class="problem_par">
      <div class="problem_par_normal">В единственной строке выведите <i>i</i> и <i>j</i>&nbsp;— номера элементов, которые нужно поменять местами, чтобы выполнить условие (1 ≤ <i>i</i>, <i>j</i> ≤ <i>n</i>, <i>i</i> ≠<i>j</i>). Если ответов несколько, выведите любой из них.</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Если не существует способа поменять два элемента местами, выведите <i>-1</i> <i>-1</i>.</div>
   </div>
   <h3 class="problem_subtitle">Примеры</h3>
   <table class="sample">
      <tbody>
         <tr>
            <th width="350">исходные данные</th>
            <th width="350">результат</th>
         </tr>
         <tr>
            <td>
               <pre>2
1 2</pre>
            </td>
            <td>
               <pre>-1 -1</pre>
            </td>
         </tr>
         <tr>
            <td>
               <pre>3
1 2 3</pre>
            </td>
            <td>
               <pre>1 3</pre>
            </td>
         </tr>
         <tr>
            <td>
               <pre>4
2 1 4 6</pre>
            </td>
            <td>
               <pre>-1 -1</pre>
            </td>
         </tr>
      </tbody>
   </table>
   <div class="problem_source"></div>
</div>
