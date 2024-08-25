import sys

N,M = map(int,sys.stdin.readline().split())

Nlist=[]

for i in range(N) :
    Nlist.append(list(map(int,sys.stdin.readline().split())))

dx = [1,1,1]
dy = [-1,0,1]

answer = 10000000000

def DFS(x,y,before,depth,totalcost) :

    global answer
    
    if depth == N :
        answer = min(answer,totalcost)
        return

    for i in range(3):

        if i != before:      
            nx = x+dx[i]
            ny = y+dy[i]

            if (0<=nx<N) and (0<=ny<M) :
                
                DFS(nx,ny,i,depth+1,totalcost+Nlist[nx][ny])

for i in range(M):
    DFS(-1,i,10,0,0)

print(answer)