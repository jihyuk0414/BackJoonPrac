def solution(s):

    slist = list(map(str,s.split(" ")))
    answerlist = []

    for i in range(len(slist)) :
        if slist[i] == "":
            answerlist.append("")
            continue
        
        appendstr = slist[i][0].upper()
        appendstr+=slist[i][1:].lower()
        answerlist.append(appendstr)
        
    answer = ' '.join(map(str,answerlist))

    
    return answer