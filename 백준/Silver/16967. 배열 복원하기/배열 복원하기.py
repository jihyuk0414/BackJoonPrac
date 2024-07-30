import sys

H, W, X, Y = map(int, sys.stdin.readline().strip().split(" "))

newarr =[]
for i in range(H+X) :
    newarr.append(list(map(int,sys.stdin.readline().split())))

answer = [ [0] * (W) for _ in range(H) ]


for i in range(H) :
    for j in range(W) :
        answer[i][j] = newarr[i][j]


for i in range(X,H):
    for j in range (Y,W) :
        answer[i][j] = newarr[i][j]-answer[i-X][j-Y]

for i in range(H):
    for j in range(W) :
        print(answer[i][j],end = " " )

    print("")
