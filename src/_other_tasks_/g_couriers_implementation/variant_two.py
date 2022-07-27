# Оптимизируйте (если потребуется) ваше решение предыдущей задачи. Решение будет запущено на тестах с большими ограничениями: 1 <= m <= 250 000.

fin = open("input.txt", 'r')
n = int(fin.readline())
orders = []
for index in range(n):
    (a, b) = fin.readline().split()
    firstTime = a.split(":")
    secondTime = b.split(":")
    orders.append([int(firstTime[0])*3600+ int(firstTime[1])*60 + int(firstTime[2]), 's'])
    orders.append([int(secondTime[0])*3600+ int(secondTime[1])*60 + int(secondTime[2]), 'f'])

fin.close()
orders.sort(key=lambda x: (x[0], x[1]))

usedCouriersMax = 0
usedCouriers = 0

for orderId in range(0, len(orders)):
    if usedCouriers > usedCouriersMax:
        usedCouriersMax = usedCouriers
    if orders[orderId][1] == 's':
        usedCouriers += 1
    if usedCouriers > usedCouriersMax:
        usedCouriersMax = usedCouriers
    if orders[orderId][1] == 'f':
        usedCouriers -= 1


print(usedCouriersMax)