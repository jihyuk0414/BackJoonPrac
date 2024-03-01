import sys

N = int(sys.stdin.readline())

Narr = list(map(int,sys.stdin.readline().split()))

dp = [1] * N

for i in range(N) :
    for j in range(0,i) :
        if Narr[i]>Narr[j] :
            dp[i]= max(dp[i],dp[j]+1)

        

print(max(dp))




        