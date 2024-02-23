import sys

N = int(sys.stdin.readline())

lengthlist = list(map(int,sys.stdin.readline().split()))

moneylist = list(map(int,sys.stdin.readline().split()))

minmoney = moneylist[0]
totalmoney = 0

for i in range(N-1):
    if moneylist[i] < minmoney :
        minmoney = moneylist[i]
    totalmoney = totalmoney + minmoney * lengthlist[i]

print(totalmoney)
