import sys

N = int(sys.stdin.readline())

lengthlist = list(map(int,sys.stdin.readline().split()))

moneylist = list(map(int,sys.stdin.readline().split()))
firstmoney = moneylist.pop(0)

ministmoneystation = moneylist.index(min(moneylist[:len(moneylist)-1]))


sumlength = sum(lengthlist)

summoney = firstmoney * lengthlist[0]
#처음 가야할 곳만큼만 충전하기
sumlength = sumlength - lengthlist[0]
#처음 간곳 만큼 길이 뺴기

for i in range(len(moneylist)) :
    if i == ministmoneystation :
        summoney = summoney + (moneylist[i] * sumlength)
        break
        #남은 거리만큼 다 여기서 산다

    else:
        #최소가 아니라면, 최소만큼만
        sumoney = summoney + (moneylist[i] * lengthlist[i-1])
        sumlength = sumlength - lengthlist[i]

print(summoney)
