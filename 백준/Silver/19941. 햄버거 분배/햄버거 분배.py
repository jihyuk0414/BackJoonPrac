import sys
N,K = map(int,sys.stdin.readline().split())

#print(N,K)

Nlist = list(map(str,sys.stdin.readline().strip()))

#print(Nlist)

for i in range(len(Nlist)) :

    if Nlist[i] == 'P' :
        start = 0
        end = 0

        if (i-K) < 0 :
            start = 0
        else:
            start = (i-K)

        if (i+K) >= N :
            end = N
        else:
            end = (i+K+1)


        for j in range(start,end) :
            if Nlist[j] == 'H' :
                Nlist[j] = 'X'
                Nlist[i] = 'O'
                break
print(Nlist.count('O'))
#print(Nlist)

