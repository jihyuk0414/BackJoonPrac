import sys

N =int(sys.stdin.readline())

s,g,p,d= map(int,sys.stdin.readline().split())

rate = sys.stdin.readline().strip()

answer = 0

countq = []

i = 0

while (i<N) :

    tear = rate[i]

    moneymonth = 0

    if len(countq) >1 :
        countq.pop(0)

    if tear == 'B':
        moneymonth = (s-1 - sum(countq))
    elif tear == 'S' :
        moneymonth = (g-1 - sum(countq))
    elif tear == 'G' :
        moneymonth = (p-1 - sum(countq))
    elif tear == 'P' :
        moneymonth = (d-1 - sum(countq))
    elif tear == 'D' :
        moneymonth = d

    answer += moneymonth
    countq.append(moneymonth)
    i+=1


print(answer)