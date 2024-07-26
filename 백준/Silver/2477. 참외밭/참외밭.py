import sys

N = int(input())

Nlist=[]

for i in range(6):
    Nlist.append(list(map(int,sys.stdin.readline().split())))

direction = []
length = []

for i in range(6):
    direction.append(Nlist[i][0])
    length.append(Nlist[i][1])

direction = direction*2
length = length*2


maxbox=[]
minbox=[]

for i in range(1,5) :

    if direction.count(i) == 2 :
        #최고 길떄
        bigindex= direction.index(i)
        maxbox.append(length[bigindex])
        smallindex = bigindex+3
        minbox.append(length[smallindex])

print((maxbox[0]*maxbox[1] - minbox[0]*minbox[1])*N)