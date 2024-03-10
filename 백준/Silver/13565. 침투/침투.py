import sys
sys.setrecursionlimit(1000000)

N,M = map(int,sys.stdin.readline().split())

graph = []
for i in range(N) :
    graph.append(list(map(int,sys.stdin.readline().strip())))
nx = [-1,1,0,0]
ny = [0,0,-1,1]

isit = False

def DFS(x,y):

    graph[x][y] = 1
    global isit

    if x == (N-1):
        isit = True
        return 

    for i in range(4):
        dx = x+nx[i]
        dy = y+ny[i]

        if (0<=dx<N) and (0<=dy<M) :
            if graph[dx][dy] == 0:
                DFS(dx,dy)
                

for i in range(M):
    DFS(0,i)

if isit:
    print("YES")
else:
    print("NO")