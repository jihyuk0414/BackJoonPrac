import sys

inputlist= list(map(int,sys.stdin.readline().split()))
N= inputlist[0]
K=inputlist[1]

coin = []

for i in range(N):
    coin.append(int(input()))

dp= [10001] * (K+1)
dp[0] = 0 

for i in coin:

    for j in range(i,K+1):
        dp[j]=min(dp[j],dp[j-i]+1)

if dp[K]==10001:
    print(-1)
else:
    print(dp[K])
