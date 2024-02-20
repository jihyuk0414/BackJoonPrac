import sys

N,M = map(int,sys.stdin.readline().split())

Nlist = [0]+list(map(int,sys.stdin.readline().split()))

dp = [0] * (N+1) 

for i in range(1,N+1) :
    dp[i] = dp[i-1]+Nlist[i]

for j in range(M) :

    start,end= map(int,sys.stdin.readline().split())
    print(dp[end]-dp[start-1])