import sys

N= int(input())

answerlist = []

for i in range(N) :
    answerlist.append(int(input()))

nownum = 1
compareindex = 0

mystack = []

correctlist = []

flag = False

while True :

    #종단 조건 필요

    if compareindex == N :
        flag = True
        break

    if nownum>N+1:
        flag = False
        break

    if len(mystack) == 0 :
        mystack.append(nownum)
        nownum+=1
        correctlist.append("+")
    
    
    elif (answerlist[compareindex] == mystack[-1]):
        mystack.pop()
        compareindex+= 1
        correctlist.append("-")
        continue

    else:
        #안맞는다
        mystack.append(nownum)
        nownum+=1
        correctlist.append("+")

if flag :
    for i in range(len(correctlist)) :
        print(correctlist[i])
else:
    print("NO")