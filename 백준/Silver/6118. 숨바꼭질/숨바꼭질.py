import sys
from collections import deque

N,M = map(int,sys.stdin.readline().split())

graph = [ [] for _ in range(N+1) ]

for i in range(M) :
    a,b= map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

#간곳이면 0 처리


visited = [0] * (N+1)

def BFS(x):

    q= deque()
    q.append(x)
    visited[x] = 1

    while q:
        comefrom = q.popleft()
        for i in graph[comefrom]:
            if visited[i] == 0 :
            #아직 안갓따면
                visited[i]= visited[comefrom]+1
                q.append(i)

BFS(1)

maxnum = max(visited)

print(visited.index(maxnum),maxnum-1,visited.count(maxnum)    )