import sys

N = int(sys.stdin.readline())

graph = [[0] * (N) for _ in range(N)]

like = []

for i in range (N**2):
    like.append(list(map(int,sys.stdin.readline().split())))

dx = [-1,1,0,0]
dy = [0,0,-1,1]


for person in like :
    sortarr = []

    for i in range(N):
        for j in range(N):

            if graph[i][j] == 0:

                prefer = 0
                empty = 0

                for a in range(4) :
                    nx = i + dx[a]
                    ny = j + dy[a]

                    if 0<=nx<(N) and 0<=ny<(N):

                        if graph[nx][ny] in person[1:] :
                            #좋아하는 사람이 있다
                            prefer += 1

                        if graph[nx][ny] == 0 :
                            empty +=1


                sortarr.append([prefer,empty,i,j])

    sortarr.sort(key = lambda x : (-x[0],-x[1],x[2],x[3]))

    

    graph[sortarr[0][2]][sortarr[0][3]]= person[0]


answer = 0

like.sort()

scorelist =[0,1,10,100,1000]

for i in range(N) :
    for j in range(N) :

        what = graph[i][j] 

        if what == 0 :
            continue
        
        cnt = 0 
        for a in range(4):
            nx = i + dx[a]
            ny = j + dy[a]

            if 0<=nx<(N) and 0<=ny<(N):

                if graph[nx][ny] in like[what-1][1:] :
                    cnt+=1
        

        answer+= scorelist[cnt]

print(answer)