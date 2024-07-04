import sys
from collections import deque

inputlist = list(map(int,sys.stdin.readline().split()))

N = inputlist[0]
M = inputlist[1]

deq = deque([i for i in range(1,N+1)])

targetlist = list(map(int,sys.stdin.readline().split()))

answer = 0 

for target in targetlist:

    while True:

        if target == deq[0]:
            deq.popleft()
            break

        else :
            if deq.index(target) <= (len(deq)//2) :
                #왼쪽에있다.
                deq.rotate(-1)
                answer+=1
            else:
                deq.rotate(1)
                answer+=1

print(answer)
