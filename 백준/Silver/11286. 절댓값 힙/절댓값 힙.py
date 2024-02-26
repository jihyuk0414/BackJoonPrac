import sys
import heapq

N= int(sys.stdin.readline())

answer = []

for i in range(N) :

    nextcome = int(sys.stdin.readline())

    if nextcome!= 0:
        heapq.heappush(answer,[abs(nextcome),nextcome])

    else:
        if len(answer) > 0 :
            print(heapq.heappop(answer)[1])
        else:
            print(0)
