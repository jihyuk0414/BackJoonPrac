import sys

N,M = map(int,sys.stdin.readline().split())

Ndict = {}

for i in range(N):
    Ndict[sys.stdin.readline().strip()] = 1

for i in range(M):
    Mlist = list(map(str,sys.stdin.readline().split(","))) 
    for x in Mlist :
        x= x.strip()
        if x in Ndict.keys() :

           if Ndict[x] != 0 :
              Ndict[x] = 0 
              N -=1 
    print(N)


