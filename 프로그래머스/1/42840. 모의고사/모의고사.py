def solution(answers):
    onelist = [1,2,3,4,5] * 2000
    twolist = [2,1,2,3,2,4,2,5] * 1250
    threelist = [3,3,1,1,2,2,4,4,5,5] *1000
    
    onecnt = 0
    twocnt = 0
    threecnt = 0
    
    for i in range(len(answers)) :
        if answers[i] == onelist[i] :
            onecnt +=1
        if answers[i] == twolist[i] :
            twocnt +=1
        if answers[i] == threelist[i] :
            threecnt +=1
            
    answer = []
    maxcnt = max(onecnt,twocnt,threecnt)
    if onecnt == maxcnt:
        answer.append(1)
    if twocnt == maxcnt:
        answer.append(2)
    if threecnt == maxcnt:
        answer.append(3)
        
    print(onecnt,twocnt,threecnt)
    return answer