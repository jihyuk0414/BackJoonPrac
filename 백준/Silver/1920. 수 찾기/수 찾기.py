import sys

N = int(input())
Nlist = list(map(int,sys.stdin.readline().split()))

M= int(input())
Mlist = list(map(int,sys.stdin.readline().split()))

no = set(Mlist)-set(Nlist)

for i in Mlist :
    if i in no :
        print(0)
    else:
        print(1)
        
