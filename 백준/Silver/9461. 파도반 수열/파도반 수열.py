import sys

T = int(sys.stdin.readline())

dp = [0]*(101)
dp[1] = 1
dp[2] = 1
dp[3] = 1
for j in range(4,101):
    dp[j] = dp[j-3]+dp[j-2]


for i in range(T):

    N= int(sys.stdin.readline())

    print(dp[N])
