import sys

N,K = map(int,sys.stdin.readline().split())

Nlist = list(map(int,sys.stdin.readline().split()))

partsum= sum(Nlist[:K])
answerlist = [partsum]

for i in range(N-K) :
    partsum = partsum - Nlist[i]+Nlist[i+K]
    answerlist.append(partsum)

    
print(max(answerlist))
