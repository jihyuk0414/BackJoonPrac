import sys
sys.setrecursionlimit(1000000)

N,M,K = map(int,sys.stdin.readline().split())

trasharr = [[0]*(M+1) for _ in range(N+1) ]
for i in range(K):
    r,c = map(int,sys.stdin.readline().split())
    trasharr[r][c] = 1

xarr =[-1,1,0,0]
yarr =[0,0,-1,1]

def DFS(x,y):

    global cnt


    for i in range(4) :
        nx = x+xarr[i]
        ny = y+yarr[i]
            
        if 0<nx<=N and 0<ny<=M and (trasharr[nx][ny] == 1) :
            trasharr[nx][ny]=0
            cnt += 1

            DFS(nx,ny)
 
maxcnt = 0
for i in range(1,N+1) :
    for j in range(1,M+1):
        if trasharr[i][j] == 1:
            trasharr[i][j] = 0
            cnt = 1
            DFS(i,j)
            maxcnt = max(maxcnt,cnt)

print(maxcnt)
