import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

graph= [[0] * (N+1) for _ in range(N+1)]

for i in range(M):
    a,b = map(int, sys.stdin.readline().split(" "))
    graph[a][b] = 1
    graph[b][a] = 1

visited = [False] * (N+1)

visited[1] = "Pass"

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def DFS(start) :

    for i in range(1,N+1) :

        if graph[start][i] == 1 :
            #갈 수 있다면
            if visited[i] == False:
                visited[i] = True
                DFS(i)

DFS(1)

cnt = 0

for i in range(1,N+1):
    if visited[i] == True:
        cnt+=1

print(cnt)