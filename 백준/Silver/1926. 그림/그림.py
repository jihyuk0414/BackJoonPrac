import sys
sys.setrecursionlimit(1000000)

N,M = map(int,sys.stdin.readline().split())

Nlist = []
for i in range (N):

    Nlist.append(list(map(int,sys.stdin.readline().split())))

nx = [-1,1,0,0]
ny = [0,0,-1,1]


def DFS(x,y) :

    global cnt
    cnt += 1
    Nlist[x][y] = 0

    for i in range(4):
        dx = x+nx[i]
        dy = y+ny[i]

        if (0<=dx<N and 0<=dy<M) and (Nlist[dx][dy] == 1 ):
            DFS(dx,dy)

    return

totalnum =0 
maxcnt = 0
for i in range(N) :
    for j in range(M):
        if Nlist[i][j] == 1 :
            cnt = 0
            DFS(i,j)
            maxcnt = max(maxcnt,cnt)
            totalnum+= 1

print(totalnum)
print(maxcnt)

