import heapq

N= int(input())

answer =[]
realanswer = 0

for i in range(N) :
    nextinput = int(input())
    heapq.heappush(answer,nextinput)


while len(answer) > 1 :
    x= heapq.heappop(answer)
    y= heapq.heappop(answer)
    realanswer+=(x+y)
    heapq.heappush(answer,x+y)

print(realanswer)
