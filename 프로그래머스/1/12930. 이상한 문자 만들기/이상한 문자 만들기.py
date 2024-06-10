def solution(s):
    answer = []
    slist = s.split(" ")
    print(slist)
    for i in range(len(slist)):
        for j in range(len(slist[i])):
            if j%2 != 0 :
                answer.append(slist[i][j].lower())
            else:
                answer.append(slist[i][j].upper())
        
        if i == len(slist)-1 :
            break
        answer.append(" ")
            
    answerstr= ''.join(answer)

    return answerstr
