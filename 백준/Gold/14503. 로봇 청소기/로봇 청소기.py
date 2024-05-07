import sys

N,M = map(int,sys.stdin.readline().split())

startx,starty,lookat = map(int,sys.stdin.readline().split())

graph = []
for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().split())))

visited = [[False]*N for _ in range (M)]

dx = [-1,0,1,0]
dy = [0,1,0,-1]

cnt = 0
def DFS(startx,starty,lookat):

    global cnt

    if graph[startx][starty] == 0 :
        graph[startx][starty] = 2
        cnt +=1 
    
    for i in range(4):
        lookat = (lookat+3)%4

        nextx = startx+dx[lookat]
        nexty = starty+dy[lookat]

        if 0<=nextx<N and 0<=nexty<M and graph[nextx][nexty] == 0 :
            #갈수 있다면
                DFS(nextx,nexty,lookat)
                return

    backx = startx-dx[lookat]
    backy = starty-dy[lookat]

    if 0<=backx<N and 0<=backy<M and graph[backx][backy] != 1 :
        DFS(backx,backy,lookat)
        
DFS(startx,starty,lookat)
print(cnt)