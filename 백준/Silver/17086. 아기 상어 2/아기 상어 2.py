import sys
from collections import deque

N,M= map(int,sys.stdin.readline().split())
graph = []

for i in range(N) :
    graph.append(list(map(int,sys.stdin.readline().split())))

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

answer =0 

def BFS(inx,iny) :

    q = deque([[inx,iny,0]])
    visited = [ [False] * M for _ in range (N) ]

    while q :
        qlist = q.popleft()
     
        x = qlist[0]
        y = qlist[1]
        cnt = qlist[2]

        for i in range(8) :
            nx = x+dx[i]
            ny = y+dy[i]

            if 0<=nx<N and 0<=ny<M and visited[nx][ny] == False :
                visited[nx][ny] = True
                q.append([nx,ny,cnt+1])

                if graph[nx][ny] == 1 :
                    return cnt+1
   
        
result = []
for i in range(N):
    for j in range(M) :
        if graph[i][j] == 0:
            result.append(BFS(i,j))

print(max(result))
