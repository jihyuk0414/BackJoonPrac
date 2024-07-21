import sys
import heapq

N= int(input())
graph = []

for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().split())))

visited = [ [False] * N for _ in range(N) ]

dx = [-1,1,0,0,0]
dy = [0,0,-1,0,1]

answer = 999999999999

def visit(x,y) :

    for i in range(5):
        if visited[x+dx[i]][y+dy[i]] == True:
            return False
    return True

def BACKTRACKING(cnt,sumcost) :

    global answer

    if cnt == 3 :
        answer = min(answer,sumcost)
        return

    for i in range(1,N-1):
        for j in range(1,N-1) :

            #BACKTRACKING
            if visit(i,j) == True :
                #방문 안했다면
                plusgo = 0
                for z in range(5):
                    visited[i+dx[z]][j+dy[z]] = True
                    plusgo += graph[i+dx[z]][j+dy[z]]

                BACKTRACKING(cnt+1,sumcost+plusgo)

                for z in range(5):
                    visited[i+dx[z]][j+dy[z]] = False


BACKTRACKING(0,0)
print(answer)
            

