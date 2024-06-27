import sys

N = int(input())

graph = [ [] for _ in range(N+1)]

findx,findy = map(int,sys.stdin.readline().split())
m = int(input())

for i in range(m) :
    parent,child = map(int,sys.stdin.readline().split())
    graph[parent].append(child)
    graph[child].append(parent)

visited = [False] *(N+1)
flag = False

def DFS(x,cnt):

    global flag

    visited[x] = True

    if x == findy :
        flag = True
        print(cnt)

    for i in range(len(graph[x])) :
        if visited[graph[x][i]] == False:
            DFS(graph[x][i],cnt+1)

answer= DFS(findx,0)

if flag== False:
    print(-1)