import sys

N,M = map(int,sys.stdin.readline().split())

Nlist= []
for i in range (N) :
    inputlist = list(map(int,sys.stdin.readline().split()))
    Nlist.append(inputlist)

dp = [ [0]*(N+1) for _ in range(N+1) ]

for i in range(1, N+1 ) :
    for j in range(1,N+1) :
        dp[i][j] = dp[i-1][j]+dp[i][j-1] + Nlist[i-1][j-1] - dp[i-1][j-1]


for i in range(M) :

    x1,y1,x2,y2 = map(int,sys.stdin.readline().split())

    print(dp[x2][y2] -dp[x2][y1-1] -dp[x1-1][y2] + dp[x1-1][y1-1])
