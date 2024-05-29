import sys

N,M = map(int,sys.stdin.readline().split())

Nlist = []

for i in range(N):
    Nlist.append(list(map(int,sys.stdin.readline().split())))

cloud = [[N-1,0],[N-2,0],[N-1,1],[N-2,1]] #왼쪽아래 왼위 좌아래 좌위

movelist = []

for i in range(M):
    movelist.append(list(map(int,sys.stdin.readline().split())))

dx = [0,-1,-1,-1,0,1,1,1]
dy = [-1,-1,0,1,1,1,0,-1]

for gogo in range(M):

    moveinfo= movelist.pop(0) 
    movedir = moveinfo[0]-1
    movelen = moveinfo[1]

    movex = dx[movedir]
    movey = dy[movedir]

    #1단계
    nextcloud = []
    
    for i in range(len(cloud)):

        nextx = (cloud[i][0]+movex*movelen) % N
        nexty = (cloud[i][1]+movey*movelen) % N
        nextcloud.append([nextx,nexty])

    #2
    visited= [[False] * N for _ in range(N)]

    for i in range(len(nextcloud)):
        x = nextcloud[i][0]
        y = nextcloud[i][1]
        Nlist[x][y]+=1
        visited[x][y] = True
    #3
    cloud = []

    #4단계
    cx = [-1,-1,1,1]
    cy = [-1,1,1,-1]
    for i in range(len(nextcloud)):
        x = nextcloud[i][0]
        y = nextcloud[i][1]
        cnt = 0 

        for j in range(4):
            if 0<=x+cx[j]<N and 0<=y+cy[j]<N :
                if Nlist[x+cx[j]][y+cy[j]]>=1 :
                    cnt +=1
        Nlist[x][y]+= cnt

    for i in range(N):
        for j in range(N):
            if Nlist[i][j] >=2 and visited[i][j] == False:
                Nlist[i][j]-=2
                cloud.append([i,j])

result = 0
for i in range(N):
    result +=sum(Nlist[i])
print(result)