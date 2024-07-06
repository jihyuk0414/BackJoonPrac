import sys

xlist = []
ylist = []

N = int(input())

for i in range(N) :
    inputlist = list(map(int,sys.stdin.readline().split()))
    x= inputlist[0]
    y = inputlist[1]
    xlist.append(x)
    ylist.append(y)
xlist.append(xlist[0])
ylist.append(ylist[0])

dx,dy= 0,0

for i in range(N):
    dx += xlist[i]*ylist[i+1]
    dy += ylist[i]*xlist[i+1]

print(round(abs((dx-dy))/2,1))
