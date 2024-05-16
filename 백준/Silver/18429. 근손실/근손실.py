import sys

N,K = map(int,sys.stdin.readline().split())

pluslist = [0]

inputlist = list(map(int,sys.stdin.readline().split()))

for i in inputlist:
    pluslist.append(i) #몇점 더할 리스트? 

visited = [False] * (N+1)

cnt = 0
cntlist = []
def backtracking(depth,point) :

    global cnt

    if depth == N and point>= 500 :
        #성공
        cnt +=1
        return

    if point< 500:
        return
    

    for i in range(1,N+1):

        if visited[i] == False:
            visited[i] = True
            cntlist.append(i)
            backtracking(depth+1,point-K+pluslist[i])
            visited[i] = False
            cntlist.pop()

backtracking(0,500)

print(cnt)