<h1 class="title">Криптограмма (31%)</h1>
<p><a href="https://acmp.ru/index.asp?main=task&id_task=905">Ссылка на задачу</a></p>
<p><b>Время: 1 сек.<br>Память: 16 Мб<br>Сложность: 31%</b></p>
<p>На одной из лекций по информатике студент Петя узнал про новый шифр - простой замены. Он и на самом деле прост: в тексте каждая буква алфавита заменяется некоторой другой буквой того же алфавита (может быть, той же самой).</p>
<p>Петя написал письмо своему другу Васе. Письмо - это текст из нескольких строк, написанный на английском языке, с использованием только строчных английских букв и пробелов. В произвольное место, отдельной строкой Петя вставил ключевую фразу: "the quick brown fox jumps over the lazy dog", о которой они с Васей договорились заранее. После чего зашифровал письмо. Известно, что пробелы в письме не шифруются. Получив такое письмо, Вася сумеет его расшифровать и прочесть. Иногда Петя ошибается, и забывает вставить ключевую фразу. Увы, в этом случае прочесть письмо невозможно.</p>
<p>Так как процесс расшифровки трудоемок, Вася просит написать программу, с помощью которой он сможет быстро расшифровывать письмо от Пети.</p>
<h2>Формат ввода</h2>
<p class=text>
Первая строка входного файла INPUT.TXT содержит целое число N – количество строк в письме (1 ≤ N ≤ 200). Далее идет N строк письма (пустые строки отсутствуют, в каждой строке не более 80 символов).
</p>
<h2>Формат вывода</h2>
<p class=text>
В выходной файл OUTPUT.TXT в случае присутствия в тексте ключевой фразы выведите N строк расшифрованного сообщения. Если ключевой фразы нет, следует вывести «No solution» (без кавычек). Гарантируется, что есть не более одного способа расшифровки текста из входных данных.
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
        <td>3<br>
            vtz ud xnm xugm itr pyy jttk gmv xt otgm xt xnm puk ti xnm fprxq<br>
            xnm ceuob lrtzv ita hegfd tsmr xnm ypwq ktj<br>
            frtjrpgguvj otvxmdxd prm iev prmvx xnmq</td>
        <td>now is the time for all good men to come to the aid of the party<br>
            the quick brown fox jumps over the lazy dog<br>
            programming contests are fun arent they</td>
     </tr>
     <tr>
         <td>3<br>
             vtz ud xnm xugm itr pyy jttk gmv xt otgm xt xnm puk ti xnm fprxq<br>
             xnm fffff lrtzv iia wwwfd tsmr xnm ypwq ktj<br>
             frtjrpgguvj otvxmdxd prm iev prmvx xnmq</td>
         <td>No solution</td>
      </tr>
  </tbody>
</table>