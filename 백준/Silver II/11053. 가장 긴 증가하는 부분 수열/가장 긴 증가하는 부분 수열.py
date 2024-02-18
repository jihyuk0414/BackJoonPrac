import sys

N = int(sys.stdin.readline())

Nlist = [0]+list(map(int,sys.stdin.readline().split()))

dp = [0]*(N+1)

for i in range(1,N+1) :
    mx= 0 
    for j in range(0,i) :
        if Nlist[i]>Nlist[j] :
            #새로들어갈 
            mx = max(mx,dp[j])
    dp[i]=mx+1


print(max(dp))

    

