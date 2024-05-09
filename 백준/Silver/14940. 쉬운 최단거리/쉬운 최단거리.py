import sys
from collections import deque

N,M = map(int,sys.stdin.readline().split())
graph = []
for i in range(M):
    graph.append(list(map(int,sys.stdin.readline().split())))

graphbefore = graph.copy()
visited = [[False]* M for _ in range(N)]

startx = 0
starty = 0

for i in range(N):
    for j in range(M):
        if graph[i][j] == 2 :
            startx = i
            starty = j
            break
            break
        
graph[startx][starty] = 0
visited[startx][starty] = True

q = deque()
q.append([startx,starty,1])

while q:
    poplist=q.popleft()
    x = poplist[0]
    y = poplist[1]
    cnt = poplist[2]

    nx = [-1,1,0,0]
    ny = [0,0,-1,1]

    for i in range(4):

        dx = x+nx[i]
        dy = y+ny[i]

        if 0<=dx<N and 0<=dy<M:
            if visited[dx][dy] == False and graph[dx][dy] != 0:
                visited[dx][dy]=True
                graph[dx][dy] = cnt
                q.append([dx,dy,cnt+1])
for i in range(N):
    for j in range(M) :
        if visited[i][j] == False and graphbefore[i][j] == 1 :
            graph[i][j] = -1
        print(graph[i][j],end = " ")
    print()
        