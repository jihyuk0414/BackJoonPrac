import sys

N,M = map(int,sys.stdin.readline().split())

def DFS() :
    
    if len(answerarr) == M :
        print(' '.join(map(str,answerarr)))
        return
    
    for i in range(1,N+1) :
        if i not in answerarr: 
            answerarr.append(i)
            DFS()
            answerarr.pop()

answerarr = []
DFS()

         