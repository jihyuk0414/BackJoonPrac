import sys

N= int(sys.stdin.readline())

Nlist = [0] +list(map(int,sys.stdin.readline().split()))

Nlist.sort()

dp = [0] * (N+1)

for i in range(1,N+1) :
    dp[i] = dp[i-1]+Nlist[i]

print(sum(dp))
    
