import sys

N = int(input())

Nlist = list(map(int,sys.stdin.readline().split()))


stack = []
answer = []

for i in range(N) :

    while stack:

        if stack[-1][1] <= Nlist[i] :
            stack.pop()

        else :
            #찾았다
            answer.append(stack[-1][0])
            break
    if len(stack) == 0 :
        answer.append(0)

    stack.append([i+1,Nlist[i]])

for i in range(N):
    print(answer[i], end= " ")
    