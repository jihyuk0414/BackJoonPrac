import sys
from collections import deque

N,S,D,F,B,K = map(int,sys.stdin.readline().split())

#0은안씀

police = list(map(int,sys.stdin.readline().split()))

graph = [0]*(N+1)

for i in police:
    graph[i] = 1
    #1은 경찰서
graph[S] = 0

def BFS(x):

    global graph

    q = deque()
    q.append(x)

    while q:
        fromx= q.popleft()

        if fromx == D:
            return True
        if (fromx-B>=1) and graph[fromx-B] == 0:
            q.append(fromx-B)
            graph[fromx-B] = graph[fromx]+1
        if (fromx+F <= N) and graph[fromx+F] == 0:
            q.append(fromx+F)
            graph[fromx+F]= graph[fromx]+1
            
    return False

        

if BFS(S) == True:
    print(graph[D])
else :
    print("BUG FOUND")