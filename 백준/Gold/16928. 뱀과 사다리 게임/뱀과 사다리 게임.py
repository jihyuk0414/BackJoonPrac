import sys
from collections import deque

inputlist = list(map(int,sys.stdin.readline().split()))
N= inputlist[0]
M =inputlist[1]

game= [ i for i in range(101)]
visited = [False] * 101

leader = {}

for i in range(N) :

    start,end= map(int,sys.stdin.readline().split())
    leader[start] = end

snake = {}

for i in range(M) :
    start,end= map(int,sys.stdin.readline().split())
    snake[start] = end

deq = deque([[1,0]])

while deq :

    xlist = deq.popleft()
    x = xlist[0]
    answer = xlist[1]
    
    if x == 100 :
        print(answer)
        break

    for i in range(1,7):

        nx = x+i

        if 1<=nx<=100 and visited[nx] == False:

            #방문 안했으면
            visited[nx] = True

            if nx in snake.keys() :
                deq.append([snake[nx],answer+1])
            elif nx in leader.keys():
                deq.append([leader[nx],answer+1])
            else:
                deq.append([nx,answer+1])
