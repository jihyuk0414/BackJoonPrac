import sys
import heapq

N= int(sys.stdin.readline())

answer = []

for i in range(N) :

    comenext = int(sys.stdin.readline())

    if comenext>0 :
        heapq.heappush(answer,comenext)

    else :
        if len(answer)==0:
            print(0)
        else:
            print(heapq.heappop(answer))
