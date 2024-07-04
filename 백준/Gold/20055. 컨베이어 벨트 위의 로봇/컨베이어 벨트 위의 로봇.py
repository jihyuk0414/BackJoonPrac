import sys
from collections import deque

inputlist = list(map(int,sys.stdin.readline().split()))

N = inputlist[0]
K = inputlist[1]

deq = deque(list(map(int,sys.stdin.readline().split())))

robot = deque([0] * N)
answer = 0

while True:

    answer+=1

    #회전
    deq.rotate(1)
    robot.rotate(1)
    robot[-1] = 0
    
    #2이동
    if sum(robot)> 0:
        for i in range(N-2,-1,-1) :

            if robot[i] == 1 and robot[i+1] == 0 and deq[i+1]>=1 :
                robot[i+1] = 1
                robot[i] = 0
                deq[i+1] -=1

        robot[-1] = 0

    #3
    if robot[0] == 0 and deq[0] >0 :
        robot[0] = 1
        deq[0] -= 1

    #4
    if deq.count(0) >= K :
        break

print(answer)