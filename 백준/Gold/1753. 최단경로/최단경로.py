import sys
import heapq

V,E = map(int,sys.stdin.readline().split())
K =int(input())
visited = [False] * (V+1)
answerlist = [sys.maxsize]*(V+1)
graph = [[] for _ in range(V+1)]

for i in range(E) :
    inputlist = list(map(int,sys.stdin.readline().split()))
    u = inputlist[0]
    v = inputlist[1]
    w = inputlist[2]

    graph[u].append([v,w])


q = []
heapq.heappush(q,[0,K])
answerlist[K] = 0 


while q :

    nowarr = heapq.heappop(q)
    nowindex = nowarr[1]

    #방문한 적이 있는가? 없으면 추가
    if visited[nowindex]==True :
        continue
    visited[nowindex] = True

    for cangolist in (graph[nowindex]) :

        cangocost = cangolist[1]
        cangonext = cangolist[0]
        if answerlist[cangonext] > answerlist[nowindex] + cangocost :
            answerlist[cangonext] = answerlist[nowindex] + cangocost
            heapq.heappush(q,[answerlist[cangonext], cangonext])

for i in range(1,len(visited)):
    if visited[i] == True :
        print(answerlist[i])
    else :
        print("INF")




