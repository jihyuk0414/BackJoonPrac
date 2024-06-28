import heapq
import sys

N = int(sys.stdin.readline().strip())

Nlist = []

for i in range(N) :
    x = list(map(int,sys.stdin.readline().split()))

    if x[0] == 0 :
        if len(Nlist) == 0 :
            print(-1)
        else:
            x = -heapq.heappop(Nlist)
            print(x)
            
    else:
        for j in range(x[0]):
            
            heapq.heappush(Nlist,-x[j+1])

    

    
