def solution(topping):
    rightdict = {}
    answer =0 
    
    for i in topping:
        if i not in rightdict:
            rightdict[i] = 1
        else:
            rightdict[i]+=1
                    
    left = set()
    
    
    for i in topping:
        rightdict[i] = rightdict[i]-1
        left.add(i)
    
        if rightdict[i] == 0 :
            rightdict.pop(i)
        
        if len(left) == len(rightdict) :
            answer+=1
        
    
    return answer