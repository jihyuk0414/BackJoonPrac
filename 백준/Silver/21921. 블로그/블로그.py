import sys

N,S =map(int,sys.stdin.readline().split())

Nlist = list(map(int,sys.stdin.readline().split()))

outcnt = 0
answerlist = [0 for _ in range(N)]
j=0
for i in range(0,len(Nlist)):
    if i == 0 :
        answerlist[i] = Nlist[i]
        continue
    elif i<=S-1:
        answerlist[i] = Nlist[i]+answerlist[i-1]
    else:
        #이제부터 DP
        answerlist[i] = Nlist[i]+answerlist[i-1]-Nlist[j]
        j+=1
        
answer = 0
howmany = 0
for i in range(len(answerlist)) :
    if answerlist[i] == answer :
        howmany +=1
    elif answerlist[i] > answer:
        answer = answerlist[i]
        howmany =1

if answer == 0 :
    print("SAD")
else:
    print(answer)
    print(howmany)

    

        
