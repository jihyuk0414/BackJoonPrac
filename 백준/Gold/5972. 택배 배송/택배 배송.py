import sys
import heapq

N,M = map(int,sys.stdin.readline().split()) 
Nlist = [[] for _ in range(N+1)]

for _ in range(M):
    x, y, cost = map(int, sys.stdin.readline().split())
    Nlist[x].append((y,cost))
    Nlist[y].append((x,cost))

distances = [float('inf') ] * (N+1)
def findroot(startindex) :
    global distances
    distances[startindex] = 0 
    heap = []
    heapq.heappush(heap,(0,startindex)) #cost는 1에서부터의 거리를의미

    while heap : 
        cost,nextindex = heapq.heappop(heap)

        if cost>distances[nextindex]:
            #1->6 > 1->4일때 (1->4->6보단 당연히 클테니)
            continue

        for next,weight in Nlist[nextindex] : 
              new_cost=cost+weight
              if new_cost<distances[next] : 
                    distances[next] = new_cost
                    heapq.heappush(heap,(new_cost,next))
findroot(1)

print(distances[N])