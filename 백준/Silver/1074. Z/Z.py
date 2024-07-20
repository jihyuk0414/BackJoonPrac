import sys

N,R,C = map(int,sys.stdin.readline().split())

ans = 0
while N :

    N -= 1

    if R < (2 ** N) and C <(2 ** N):
        ans += 0

    elif R < (2 ** N) and C >=(2 ** N):
        #1사
        ans += (2**N) * (2 ** N) * 1
        C -= 2**N

    elif R >= (2 ** N) and C <(2 ** N):
        ans += (2**N) * (2 ** N) * 2
        R -= 2**N

    else:
        ans += (2**N) * (2 ** N) * 3
        C -= 2**N
        R -= 2**N


print(ans)
