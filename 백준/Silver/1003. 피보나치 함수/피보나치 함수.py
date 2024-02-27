import sys

dp = [[0,0] for _ in range(41)]
dp[0] = [1,0]
dp[1] = [0,1]

T = int(sys.stdin.readline())

for i in range(T) :

    zerosum = 0
    onesum = 0

    N= int(sys.stdin.readline())

    for j in range(2,N+1):
        dp[j][0] = dp[j-1][0]+dp[j-2][0]
        dp[j][1] = dp[j-1][1]+dp[j-2][1]
    
    print(dp[N][0],dp[N][1])




