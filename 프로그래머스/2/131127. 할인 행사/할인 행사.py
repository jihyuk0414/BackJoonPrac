def solution(want, number, discount):
    answer = 0
    adict = {}
    
    for i in range(len(number)) :
        adict[want[i]] = number[i]
    
    answer = 0
    
    for i in range(len(discount)-9)  :
        buydict = adict.copy()
        for j in range(i,i+10) : 
            if discount[j] in buydict and buydict[discount[j]] > 0 :
                buydict[discount[j]] -= 1

                
        if sum(buydict.values()) == 0 :
            print(i)
            answer+=1 
            
            
    return answer