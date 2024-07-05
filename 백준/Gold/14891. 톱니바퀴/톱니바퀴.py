import sys
from collections import deque

chain = [0]

for i in range(4) :
    chain.append( deque(list(map(int,sys.stdin.readline().strip()))))

Klist = []
K= int(input())

for i in range(K) :
    Klist.append(list(map(int,sys.stdin.readline().split())))

def right(idx,d) :

    if idx>=4 :
        return 
    else:
        if chain[idx][2] != chain[idx+1][6]:
            right(idx+1,-d)
            chain[idx+1].rotate(-d)

def left(idx,d):
    if idx<=1 :
        return 
    else:
        if chain[idx][6] != chain[idx-1][2] :
            left(idx-1,-d)
            chain[idx-1].rotate(-d)


for i in range(K) :

    whatchain = Klist[i][0]
    how = Klist[i][1]

    right(whatchain,how)
    left(whatchain,how)
    

    chain[whatchain].rotate(how)


answer = 0
for i in range(1,5) :

    if chain[i][0] == 1:

        answer += 2 ** (i-1)
print(answer)
