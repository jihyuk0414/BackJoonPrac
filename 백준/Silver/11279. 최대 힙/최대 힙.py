import sys
import heapq

N = int(sys.stdin.readline())

answerqueue = []

for i in range(N) :

    comein = int(sys.stdin.readline())

    if comein >0 :
        heapq.heappush(answerqueue,-comein)

    else:
        if len(answerqueue) == 0 :
            print(0)
            continue
        else:
            print(-heapq.heappop(answerqueue))
        


