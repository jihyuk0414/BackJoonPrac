import sys

strN,strK = sys.stdin.readline().split()
N =int(strN)
K= int(strK)

#DP
Nlist = [[0,0]]

for i in range(N):
    Nlist.append(list(map(int,sys.stdin.readline().split())))


dp = [[0] * (K+1) for _ in range(N+1)]

for i in range(1,N+1) :

    for j in range(1,K+1) :

        weight= Nlist[i][0]
        value= Nlist[i][1]

        if j<weight:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j]= max(dp[i-1][j],dp[i-1][j-weight]+value)

print(dp[N][K])
