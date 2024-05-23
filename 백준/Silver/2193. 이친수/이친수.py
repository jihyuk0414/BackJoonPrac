N = int(input())

check = True
if N ==1 :
    print(1)
    check = False

if check == True:
    dp = [0] * N

    dp[0] = 1
    dp[1] = 1

    for i in range(2,N) :

        dp[i] = dp[i-1]+dp[i-2]

    print(dp[-1])