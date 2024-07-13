import sys
H,W = map(int,sys.stdin.readline().strip().split())

blocks = list(map(int,sys.stdin.readline().split()))
answer = 0

for i in range(1,W-1) :

    left_max = max(blocks[:i])
    right_max = max(blocks[i:])

    if left_max> blocks[i] and right_max> blocks[i] :
        #둘다 자기보다 크다 .
        answer += min(left_max,right_max)-blocks[i]

    else :
        continue

print(answer)
