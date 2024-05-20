import sys

L,C = map(int,sys.stdin.readline().split())
inputarr = list(sys.stdin.readline().split())
moem = ['a','e','i','o','u']

inputarr.sort()

def check(answerarr):

    moemcnt = 0
    jaemcnt = 0 
    for i in answerarr:
        if i in moem:
            moemcnt+=1

        if i not in moem:
            jaemcnt+=1

    if moemcnt>=1 and jaemcnt>=2 :
        return True

    else:
        return False

def backtracking(answerarr) :

    if len(answerarr) == L :
        if check(answerarr):

            print(''.join(answerarr))
            return

    if len(answerarr) == 0 :
        for i in range(0,C-L+1) :
            answerarr.append(inputarr[i])
            backtracking(answerarr)
            answerarr.pop()

    else:
        
        for i in range(len(answerarr),C) :
            if answerarr[-1] < inputarr[i] :
                answerarr.append(inputarr[i])
                backtracking(answerarr)
                answerarr.pop()

      

ansarr = []
backtracking(ansarr)