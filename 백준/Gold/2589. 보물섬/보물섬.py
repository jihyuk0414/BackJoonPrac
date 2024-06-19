import sys
from collections import deque

N,M = map(int,sys.stdin.readline().split())
Nlist= []


for i in range(N) :
    Nlist.append(list(sys.stdin.readline().strip()))

nx = [-1,1,0,0]
ny = [0,0,-1,1]

def BFS(starty,startx) :

    q = deque()
    q.append([starty,startx,0])
    
    visited= [ [False] * M for _ in range(N) ]
    visited[starty][startx] = True
    maxcnt = 0

    while q:

        alist = q.popleft()
        y= alist[0]
        x= alist[1]
        cnt = alist[2]
        maxcnt = max(maxcnt,cnt)

        for i in range(4):

            dx = x+nx[i]
            dy = y+ny[i]

            if 0<=dx<M and 0<=dy<N and Nlist[dy][dx] == 'L':
                if visited[dy][dx] == False:
                    #방문 안했으면
                    visited[dy][dx] = True
                    q.append([dy,dx,cnt+1])
                    
    return maxcnt

answer = 0

for i in range(N) :
    for j in range(M):

        if Nlist[i][j] == 'L' :
            if 0 <= i - 1 < N and 0 <= i + 1 < N:
                if Nlist[i - 1][j] == 'L' and Nlist[i + 1][j] == 'L':
                    continue
            if 0 <= j - 1 < M and 0 <= j + 1 < M:
                if Nlist[i][j - 1] == 'L' and Nlist[i][j + 1] == 'L':
                    continue
            bfscnt = BFS(i,j)
            answer = max(answer,bfscnt)

print(answer)