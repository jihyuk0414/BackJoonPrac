import sys

N= int(sys.stdin.readline())

Nlist = [0]+list(map(int,sys.stdin.readline().split()))

dp = [0] * (N+1)

for i in range(1,N+1) :
    
    maxnum = 0 
    for j in range(0,i) :
        if Nlist[j]> Nlist[i] :
            maxnum= max(maxnum,dp[j])

    dp[i] = maxnum+1


print(max(dp))
