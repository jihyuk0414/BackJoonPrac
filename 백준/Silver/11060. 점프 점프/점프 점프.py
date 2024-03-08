import sys
N = int(sys.stdin.readline())

Nlist = list(map(int,sys.stdin.readline().split()))

dp = [0] * (N)


for i in range(N):

    if Nlist[i] ==0 :
        continue

    for j in range(1,Nlist[i]+1) :
        if ( i!= 0) and (dp[i] == 0 ) :
            break

        
        if (i+j) < N :
            if dp[i+j] == 0 :
                dp[i+j] = dp[i]+1
            else:
                dp[i+j] = min(dp[i+j],dp[i]+1)


if (N ==1) and (len(Nlist) == 1) and Nlist[0] == 0 :
    print(0)
elif (dp[-1] == 0):
    print(-1)
else:
    print(dp[-1])
    
