def solution(want, number, discount):
    answer = 0
    answerdict = {}
    
    for i in range(len(want)) :
        answerdict[want[i]] = number[i]
    
    
    for i in range(0,len(discount)-10+1):
        discountarr = discount[i:i+10] 
        
        cntdict = answerdict.copy()
        
        for product in discountarr :
            if product in cntdict.keys():
                cntdict[product]-=1         
        
        zerocnt = True
        
        for i in cntdict.values():
            if i !=0 :
                zerocnt = False
                break
        if zerocnt == True:
            answer+=1
        
    return answer