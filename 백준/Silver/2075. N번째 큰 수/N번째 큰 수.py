import heapq
import sys

N = int(input())

nlist= []
for i in range(N):
    inputlist= list(map(int,sys.stdin.readline().split()))
    for j in inputlist:
        if len(nlist) < N :
            heapq.heappush(nlist,j)
        else:
            #넘어버렸다?
            if j > nlist[0] :
                heapq.heappop(nlist)
                heapq.heappush(nlist,j)

print(nlist[0])

