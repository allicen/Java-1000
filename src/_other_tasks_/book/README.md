<h1 class="title">E. Книжный шкаф</h1>
<p><b>Время: 2 сек.<br>Память: 256 Мб</b></p>
<div id="problem_text">
   <div class="problem_par">
      <div class="problem_par_normal">Андрей любит читать, поэтому он недавно устроился в библиотеку. Библиотека оказалось необычной: размер книги здесь напрямую связан с ростом человека, который её читает. Недавно в библиотеку завезли новый книжный шкаф. Он быстро заполнился, так как посетителей в библиотеке было довольно много. Андрей проявлял активность и внимательно следил за тем, как люди ставят и забирают книги из шкафа.</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Тем временем шкаф оказался довольно необычным&nbsp;— полки в нём расположены на разных высотах. Первая полка расположена на высоте <i>h</i><sub>1</sub> от пола, вторая&nbsp;— на высоте <i>h</i><sub>2</sub>, …, <i>n</i>-я полка расположена на высоте <i>h</i><sub><i>n</i></sub>. </div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Достаточно изучив, как люди кладут и забирают книги, Андрей заметил, что человек с ростом <i>height</i> не может поставить свою книгу на полку высотой больше <i>height</i>, а также на полку высотой меньше <i>height</i> / <i>k</i>. Также он заметил, что у человека с ростом <i>height</i> размер книги явно не меньше <i>height</i> / <i>m</i><sub>1</sub> и не больше <i>height</i> / <i>m</i><sub>2</sub>. </div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Теперь Андрей смотрит на шкаф, и ему кажется, что некоторые книги появились там волшебным образом&nbsp;— ни один человек не мог их туда поставить, исходя из его наблюдений. Помогите ему проверить это&nbsp;— посчитайте количество книг, которые не удовлетворяют наблюдениям.</div>
   </div>
   <h3 class="problem_subtitle">Исходные данные</h3>
   <div class="problem_par">
      <div class="problem_par_normal">В первой строке дано число <i>n</i>&nbsp;— количество полок в шкафу (1 ≤ <i>n</i> ≤ 10<sup>5</sup>).</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Во второй строке даны три числа: <i>k</i>, <i>m</i><sub>1</sub> и <i>m</i><sub>2</sub>&nbsp;— коэффициенты, выведенные Андреем (1 ≤ <i>k</i> ≤ 100; 1 ≤ <i>m</i>2 ≤ <i>m</i>1 ≤ 100).</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">В следующих <i>n</i> строках дано описание полок: для <i>i</i>-й полки сначала дано число <i>h</i><sub><i>i</i></sub>&nbsp;— её высота (1 ≤ <i>h</i><sub>1</sub> ≤ 10<sup>7</sup>, <i>h</i><sub><i>i</i>−1</sub> &lt; <i>h</i><sub><i>i</i></sub> ≤ 10<sup>7</sup> для всех <i>i</i> &gt; 1). Далее дано число <i>k</i><sub><i>i</i></sub>&nbsp;— количество книг на этой полке (1 ≤ <i>k</i><sub><i>i</i></sub> ≤ 10<sup>5</sup>). После этого даны <i>k</i><sub><i>i</i></sub> чисел <i>size</i><sub><i>i</i>,<i>j</i></sub>&nbsp;— размеры книг на полке (1 ≤ <i>size</i><sub><i>i</i>, <i>j</i></sub> ≤ 10<sup>7</sup>).</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Гарантируется, что сумма всех <i>k</i><sub><i>i</i></sub> не превосходит 10<sup>5</sup>.</div>
   </div>
   <h3 class="problem_subtitle">Результат</h3>
   <div class="problem_par">
      <div class="problem_par_normal">В единственной строке выведите количество книг, которые не удовлетворяют наблюдениям Андрея.</div>
   </div>
   <h3 class="problem_subtitle">Пример</h3>
   <table class="sample">
      <tbody>
         <tr>
            <th width="350">исходные данные</th>
            <th width="350">результат</th>
         </tr>
         <tr>
            <td>
               <pre>3
2 1 1
1 2 1 2
2 2 1 4
4 2 3 4</pre>
            </td>
            <td>
               <pre>2</pre>
            </td>
         </tr>
      </tbody>
   </table>
   <h3 class="problem_subtitle">Замечания</h3>
   <div class="problem_par">
      <div class="problem_par_normal">В примере всего две книги, не удовлетворяющие наблюдениям Андрея&nbsp;— книга размером 1 на полке высотой 2 и книга размером 3 на полке высотой 4.</div>
   </div>
   <div class="problem_source"></div>
</div>
