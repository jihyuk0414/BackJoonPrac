def solution(progresses, speeds):
    answerarr = []
    doday = 0 
    answerdict = {}
    
    for i in range(len(progresses)) : 
        day = 0 
        lefttime = (100-progresses[i])
        while True : 
            if lefttime <= 0 :
                answerarr.append(day)
                break
            lefttime = lefttime - speeds[i]
            day +=1
    print(answerarr)
    
    for i in range(len(answerarr)) :
        if i == 0 :
            answerdict[answerarr[i]] = 1
            continue
        maxvalue = max(answerdict.keys()) 
        
        if answerarr[i] <= maxvalue : 
            answerdict[maxvalue] += 1
        
        else :
            answerdict[answerarr[i]] = 1
    return list(answerdict.values())        
  
        
