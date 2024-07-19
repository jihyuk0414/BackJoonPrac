import sys

N = int(input())
Nlist = list(map(int,sys.stdin.readline().split()))

realanswer = 0
visited= [False] * N

def DFS(answerarr,depth) :

    global realanswer
    global visited

    if depth == N :
        #다돌았다.
        answer =0 
        for i in range(N-1):
            answer += abs(answerarr[i]-answerarr[i+1])
        realanswer = max(answer,realanswer)
        return

    for i in range(len(Nlist)):
        if visited[i] == False :
            visited[i] = True
            answerarr.append(Nlist[i])
            DFS(answerarr,depth+1)
            visited[i] = False
            answerarr.pop()
            
                
DFS([],0)

print(realanswer)
