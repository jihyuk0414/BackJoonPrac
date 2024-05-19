import sys

N,M = map(int,sys.stdin.readline().split())

alist = [ i for i in range(N+1) ]
    
selected = []

visited = [False] * (N+1)

def backtracking(depth,start) :

    if len(selected)== M:

        #오름차순인지 check
        if selected == sorted(selected) :
            print(' '.join(map(str,selected)))

        return
    
    if depth >=N :
        return
    
    selected.append(alist[start+1])
    backtracking(depth+1,start+1)
    selected.pop()
    
    backtracking(depth+1,start+1)

backtracking(0,0)

