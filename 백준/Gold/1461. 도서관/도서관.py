import sys

inputlist = list(map(int,sys.stdin.readline().split()))
N=inputlist[0]
M = inputlist[1]

Nlist = list(map(int,sys.stdin.readline().split()))
plustlist = []
minuslist= []
maxdir = 0 

for i in Nlist :
    if i >= 0 :
        plustlist.append(i)
    else :
        minuslist.append(i)

    if abs(i) > abs(maxdir) :
        maxdir = i

plustlist.sort(reverse=True)
minuslist.sort()
    
answer =0 
for i in range(0,len(plustlist),M) : 

    if plustlist[i] != maxdir :
        answer += plustlist[i]
    
for i in range(0,len(minuslist),M) :

    if minuslist[i] != maxdir:
        answer += abs(minuslist[i])
    
answer *= 2

answer += abs(maxdir)

print(answer)



