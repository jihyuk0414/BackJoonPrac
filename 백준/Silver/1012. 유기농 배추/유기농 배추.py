import sys
sys.setrecursionlimit(10**6)

T = int(input())

dx = [-1,0,1,0]
dy = [0,1,0,-1]


def DFS (x,y):
    
    for i in range(4) : 
        nx = x+dx[i]
        ny = y+dy[i]

        if 0<=nx<N and 0<=ny<M :
            if Nlist[nx][ny] == 1 :
                Nlist[nx][ny] =0 
                DFS(nx,ny)
    

for i in range(T) :
    listtwo = list(map(int,sys.stdin.readline().split()))

    M = listtwo[0]
    N = listtwo[1]
    K = listtwo[2]

    Nlist = [ [0] * M for _ in range(N) ]

    for i in range(K) :
        xylist = list(map(int,sys.stdin.readline().split()))
        x = xylist[0]
        y = xylist[1]
        Nlist[y][x] = 1
    answer =0 

    for i in range(N):
        for j in range(M):
            if Nlist[i][j] == 1 :
                Nlist[i][j] = 0
                answer+=1
                DFS(i,j)
    print(answer)
    
        
