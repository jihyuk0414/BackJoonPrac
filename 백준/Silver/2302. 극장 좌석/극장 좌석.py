import sys

N = int(sys.stdin.readline())
dp = [1] * (N+1)


if N != 1:
    dp[2] = 2
    for i in range(3,N+1):
        dp[i] = dp[i-1]+dp[i-2]


M = int(sys.stdin.readline())

doit = True
if M == 0 :
    print(dp[N])
    doit = False

answer = 1
lastnumber = 0
for i in range(M) :
        #i는 안씁니다
        
        inputnumber = int(sys.stdin.readline())
        plusnumber = inputnumber-lastnumber-1
        answer = answer * dp[plusnumber]
        lastnumber = inputnumber

        
        if i == (M-1):
            answer = answer*dp[N-inputnumber]
if doit :
    print(answer)
        
