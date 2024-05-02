import sys
sys.setrecursionlimit(10000000)

strN,strM = sys.stdin.readline().split()

N= int(strN)
M= int(strM)
graph = []
for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().split())))

checkgraph = [[True] * M for _ in range(N) ]

answer = 0

def DFS(level,x,y,sumval) :
    global answer

    if level == 4 :
        answer = max(answer,sumval)
        return

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]

    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]

        if 0<=nx<N and 0<=ny<M and checkgraph[nx][ny] == True :
            checkgraph[nx][ny] = False
            DFS(level+1,nx,ny,sumval+graph[nx][ny])
            checkgraph[nx][ny] = True

    return

for i in range(N):
    for j in range(M):
        checkgraph[i][j] = False
        DFS(1,i,j,graph[i][j])
        checkgraph[i][j] = True
#ㅏ
for i in range(N-2):
    for j in range(M-1):
        answer = max(answer,graph[i][j]+graph[i+1][j]+graph[i+2][j]+graph[i+1][j+1])
#ㅓ
for i in range(N-2):
    for j in range(M-1):
        answer = max(answer,graph[i][j+1]+graph[i+1][j]+graph[i+1][j+1]+graph[i+2][j+1])
#ㅗ
for i in range(N-1):
    for j in range(M-2):
        answer = max(answer,graph[i][j+1]+graph[i+1][j]+graph[i+1][j+1]+graph[i+1][j+2])
#ㅜ
for i in range(N-1):
    for j in range(M-2):
        answer = max(answer,graph[i][j]+graph[i][j+1]+graph[i][j+2]+graph[i+1][j+1])

print(answer)