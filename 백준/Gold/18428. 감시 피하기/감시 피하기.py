import sys
from copy import deepcopy

N = int(input())

Nlist = []

for i in range(N):

    Nlist.append(list(map(str,sys.stdin.readline().split())))
    

def check(graph) :

    dx= [0,-1,0,1]
    dy = [-1,0,1,0]
    
    for i in range(N) :
        for j in range(N) :

            if graph[i][j] == 'T' :
                for z in range(4) :
                    nx = i+dx[z]
                    ny = j+dy[z]
                    while 0<=nx<N and 0<=ny<N :
                        if graph[nx][ny] == 'O' :
                            break
                        if graph[nx][ny] == 'S' :
                            return False
                        nx += dx[z]
                        ny += dy[z]

    return True
            

def DFS(graph,depth) :

    global answer

    if depth == 3 :
        if check(graph) == True :
            answer = "YES"
        return
            
        

    for i in range(N) :
        for j in range(N) :
            if graph[i][j] == 'X' :
                graph[i][j] = 'O'
                DFS(graph,depth+1)
                graph[i][j] = 'X'
answer = "NO"

DFS(deepcopy(Nlist),0)


print(answer)