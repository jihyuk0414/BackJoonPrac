import sys

N= int(sys.stdin.readline())

Nlist = []

for i in range(N) :
    Nlist.append(list(map(int,sys.stdin.readline().split())))

Nlist.sort(key = lambda x : (x[1],x[0]))

cnt = 1
beforeend = Nlist[0][1]

for i in range (1,N) :

    if Nlist[i][0] >= beforeend :

        beforeend = Nlist[i][1]
        cnt += 1

print(cnt)
