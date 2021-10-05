<h1 class="title">B. Га-га 3</h1>
<p><b>Время: 2 сек.<br>Память: 256 Мб</b></p>
<div id="problem_text">
   <div class="problem_par">
      <div class="problem_par_normal">Саша &nbsp;— очень избалованный гусь.</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Недавно он нашёл кубики, на которых написаны числа. Саша пытался с ними поиграть, но вскоре ему стало скучно, поэтому он стал строить из них высокую башню. Сейчас в его башне <i>n</i> кубиков, на каждом из которых написано некоторое натуральное число <i>a</i><sub><i>i</i></sub>. </div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Саше, как и всем остальным гусям, стало интересно, чему равно значение степенной башни <i>a</i><sub>1</sub><sup><i>a</i><sub>2</sub><sup><i>a</i><sub>3</sub> …</sup><sup><sup><i>a</i><sub><i>n</i></sub></sup></sup></sup>. Так как Саша — гусь, больших чисел он в голове удержать не может, поэтому хочет узнать результат по модулю 3. Помогите Саше.</div>
   </div>
   <div class="problem_par">
      <div class="problem_par_normal">Напомним, что операция возведения в степень правоассоциативна.</div>
   </div>
   <h3 class="problem_subtitle">Исходные данные</h3>
   <div class="problem_par">
      <div class="problem_par_normal">В первой строке находится натуральное число <i>n</i> (1 ≤ <i>n</i> ≤ 10<sup>5</sup>). В следующей строке находятся <i>n</i> натуральных чисел <i>a</i><sub><i>i</i></sub> (1 ≤ <i>a</i><sub><i>i</i></sub> ≤ 10<sup>9</sup>).</div>
   </div>
   <h3 class="problem_subtitle">Результат</h3>
   <div class="problem_par">
      <div class="problem_par_normal">Выведите результат выражения <i>a</i><sub>1</sub><sup><i>a</i><sub>2</sub><sup><i>a</i><sub>3</sub> …</sup><sup><sup><i>a</i><sub><i>n</i></sub></sup></sup></sup><i> mod 3</i>.</div>
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
               <pre>3
1 2 3</pre>
            </td>
            <td>
               <pre>1</pre>
            </td>
         </tr>
         <tr>
            <td>
               <pre>3
2 3 2
</pre>
            </td>
            <td>
               <pre>2</pre>
            </td>
         </tr>
      </tbody>
   </table>
   <h3 class="problem_subtitle">Замечания</h3>
   <div class="problem_par">
      <div class="problem_par_normal">Во втором примере 2<sup>3<sup>2</sup></sup><i> = 512 mod 3 = 2</i>.</div>
   </div>
   <div class="problem_source"></div>
</div>
