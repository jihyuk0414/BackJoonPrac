import sys
from collections import deque

M, N, K = map(int, sys.stdin.readline().split())

graph = [[0]* N for _ in range(M)] 

for _ in range(K):
    X1, Y1, X2, Y2 = map(int, sys.stdin.readline().split())
    for Y in range(Y1, Y2):
        for X in range(X1, X2):
            graph[Y][X] = 1

q = deque()

visited= [ [False] *N for _ in range(M) ]

nx=[-1,1,0,0]
ny = [0,0,-1,1]
answer = 0

def DFS(x,y) :

    cnt = 1 

    q.append([x,y])
    visited[x][y] = True

    while q :
        alist = q.popleft()
        newx= alist[0]
        newy = alist[1]
        for i in range(4) :
            dx = nx[i]+newx
            dy = ny[i]+newy

            if 0<=dx<M and 0<=dy<N and graph[dx][dy] == 0:
                if visited[dx][dy] == False:              
                    q.append([dx,dy])
                    visited[dx][dy] = True
                    cnt +=1 

    return cnt
dfslist = []

for i in range(M):
    for j in range(N):
        if graph[i][j] == 0 and visited[i][j] == False:
            answer+=1
            dfslist.append(DFS(i,j))
            
print(answer)
dfslist.sort()
for i in dfslist:
    print(i, end = " ")