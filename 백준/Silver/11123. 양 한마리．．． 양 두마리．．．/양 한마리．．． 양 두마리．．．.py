import sys
sys.setrecursionlimit(1000000)
N = int(sys.stdin.readline())

nx = [-1,1,0,0]
ny = [0,0,-1,1]

def DFS(x,y):

    global Nlist
    global H
    global W

    Nlist[x][y] = '.'

    for i in range(4):
        dx = x+nx[i]
        dy = y+ny[i]

        if (0<=dx<H) and (0<=dy<W):
            if Nlist[dx][dy] == '#' :
                #아직 안감.
                Nlist[dx][dy] = '.'
                DFS(dx,dy)
                

for i in range(N) :
    H,W = map(int,sys.stdin.readline().split())
    Nlist = []

    for j in range(H):
        Nlist.append(list(sys.stdin.readline().strip()))
    cnt = 0 

    for i in range(H):
        for j in range(W):
            if Nlist[i][j] == '#' :
                DFS(i,j)
                cnt+= 1
    print(cnt)

    
