import sys
sys.setrecursionlimit(1000000)

N = int(input())
Nlist = [ [] for _ in range(N+1)]

for i in range(1,N+1) :
    Nlist[i].append(int(input()))

answerset = set()

def DFS(nowindex,startset,endset) :

    global answerset
    global visited
    
    if visited[nowindex] == False:
        #아직 안갔다면
        visited[nowindex] = True
        nextindex = Nlist[nowindex][0]

        startset.add(nowindex)
        endset.add(nextindex)

        if(startset == endset) :
            answerset.update(startset)
            return

        DFS(nextindex,startset,endset)
        
for i in range(1,N+1) :
    visited = [False] * (N+1)
    startset = set()
    endset = set()
    DFS(i,startset,endset)
answerlist = list(answerset)
answerlist.sort()
print(len(answerlist))
for i in range(len(answerlist)):
    print(answerlist[i])