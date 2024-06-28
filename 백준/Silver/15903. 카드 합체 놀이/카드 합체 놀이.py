import heapq
import sys

inputlist = list(map(int,sys.stdin.readline().split()))
N= inputlist[0]
M= inputlist[1]

Nlist = list(map(int,sys.stdin.readline().split()))

heapq.heapify(Nlist)


for j in range(M):
    x = heapq.heappop(Nlist)
    y = heapq.heappop(Nlist)

    z = x+y

    heapq.heappush(Nlist,z)
    heapq.heappush(Nlist,z)

print(sum(Nlist))