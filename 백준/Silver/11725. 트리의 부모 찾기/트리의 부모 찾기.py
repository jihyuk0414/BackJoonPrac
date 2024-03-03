import sys

sys.setrecursionlimit(1000000)

N = int(sys.stdin.readline())
Nlist =[[] for _ in range(N+1)]

for i in range(N-1):
    a,b=list(map(int,sys.stdin.readline().split()))
    Nlist[a].append(b)
    Nlist[b].append(a)


visited = [0] * (N+1)
#0이 안방문한거

def DFS(startindex) :
    for i in Nlist[startindex]:
        if visited[i] == 0 :
            visited[i] = startindex
            DFS(i)
DFS(1)

for i in range(2,len(visited)) :
    print(visited[i])
    