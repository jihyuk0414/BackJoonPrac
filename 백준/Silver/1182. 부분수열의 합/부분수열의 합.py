import sys

N,S = map(int,sys.stdin.readline().split())

alist = list(map(int,sys.stdin.readline().split()))

answer = 0
def backtracking(depth,total):

    global answer

    if depth >=N :
        return

    total+=alist[depth]
    
    if (total == S) :
        answer+=1

    backtracking(depth+1,total-alist[depth])

    backtracking(depth+1,total)
        

backtracking(0,0)
print(answer)
    