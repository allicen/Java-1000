<h1 class="title">Дипломы (28%)</h1>
<p><a href="https://acmp.ru/index.asp?main=task&id_task=712" target="_blank">Ссылка на задачу</a></p>
<p><b>Время: 1 сек.<br>Память: 16 Мб<br>Сложность: 28%</b></p>
<p>Когда Петя учился в школе, он часто участвовал в олимпиадах по информатике, математике и физике. Так как он был достаточно способным мальчиком и усердно учился, то на многих из этих олимпиад он получал дипломы. К окончанию школы у него накопилось n дипломов, причем, как оказалось, все они имели одинаковые размеры: w – в ширину и h – в высоту.</p>
<p>Сейчас Петя учится в одном из лучших российских университетов и живет в общежитии со своими одногруппниками. Он решил украсить свою комнату, повесив на одну из стен свои дипломы за школьные олимпиады. Так как к бетонной стене прикрепить дипломы достаточно трудно, то он решил купить специальную доску из пробкового дерева, чтобы прикрепить ее к стене, а к ней – дипломы. Для того чтобы эта конструкция выглядела более красиво, Петя хочет, чтобы доска была квадратной и занимала как можно меньше места на стене. Каждый диплом должен быть размещен строго в прямоугольнике размером w на h. Прямоугольники, соответствующие различным дипломам, не должны иметь общих внутренних точек.</p>
<p>Требуется написать программу, которая вычислит минимальный размер стороны доски, которая потребуется Пете для размещения всех своих дипломов.</p>
<h2>Формат ввода</h2>
<p>Входной файл input.txt содержит три целых числа: w, h, n (1 ≤ w, h, n ≤ 10<sup>9</sup>).</p>
<h2>Формат вывода</h2>
<p>В выходной файл output.txt выведите ответ на задачу.</p>
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
        <td>2 3 10</td>
        <td>9</td>
     </tr>
  </tbody>
</table>

<p><strong>Алгоритм</strong></p>
<p>Из-за больших ограничений на n,w,h линейный перебор возможной длины стороны квадрата не проходит по времени, поэтому данную задачу следует решать, используя бинарный поиск по ответу. Очевидно, что размеры доски лежат в пределах от min(w,h) до n * max(w,h). За O(1) легко проверить, поместятся ли все грамоты в квадрат со стороной a (n <= (a / w) * (a / h)). Пускай мы уверены, что искомый ответ лежит в интервале от Min до Max, тогда проверим удовлетворяет ли условию квадрат со стороной Mid = (Min + Max) / 2. Если да, то Max = Mid, иначе Min = Mid+1. Выполняя эту процедуру до тех пор, пока не сойдутся Min и Max мы будем всё точнее получать возможный диапазон ответа (каждый раз область поиска уменьшается в 2 раза). Когда Min станет равно Max выведем значение Min и прекратим работу программы. Сложность такого решения: O(log(n*max(w,h))).
</p>