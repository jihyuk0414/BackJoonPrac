import sys

N,M = map(int,sys.stdin.readline().split())

A= []

for i in range(N) :
    A.append(list(map(int,sys.stdin.readline().split())))

M,K= map(int,sys.stdin.readline().split())

B= []
for i in range(M) :
    B.append(list(map(int,sys.stdin.readline().split())))

C = [ [0] * (K) for i in range(N)] 

for k in range (K):
    for n in range (N) :
        for m in range(M) :
            C[n][k] = C[n][k] + (A[n][m]*B[m][k])

for i in C:
    for j in i:
        print(j,end= " ")
    print() 
