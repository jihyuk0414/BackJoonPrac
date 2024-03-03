import sys
sys.setrecursionlimit(1000000)

N,M = map(int,sys.stdin.readline().split())

Nlist = []

for i in range(M) :
    Nlist.append(list(sys.stdin.readline().strip()))

Wsum = 0
Bsum = 0

xlist=[-1,1,0,0]
ylist=[0,0,-1,1]

def DFS(x,y,color,cnt):

    Nlist[x][y] = 1 

    for i in range(4) :
        nx = x+xlist[i]
        ny = y+ylist[i]
        if 0<=nx<M and 0<=ny<N :
            if Nlist[nx][ny] == color :
                cnt = DFS(nx,ny,color,cnt+1)
    return cnt 

for i in range(M):
    for j in range(N) :
        if Nlist[i][j] == "W" :
            Wsum = Wsum + DFS(i,j,"W",1) ** 2
        elif Nlist[i][j] == "B" :
            Bsum = Bsum + DFS(i,j,"B",1) ** 2

print(Wsum, Bsum)