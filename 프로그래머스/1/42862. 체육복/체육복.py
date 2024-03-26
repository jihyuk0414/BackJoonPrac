def solution(n, lost, reserve):
    
    t1= set(lost)
    t2= set(reserve)
    
    lost = list(t1-t2)
    reserve = list(t2-t1)
    
    lost.sort()
    reserve.sort()
    
    answer = n
    answer = answer -len(lost)
 

    for i in range(len(lost)) :
        
        if len(reserve) == 0 :
            break
            
        for j in range(len(reserve)) :
            if (lost[i] == reserve[j] )or (lost[i] == reserve[j]-1) or (lost[i] == reserve[j]+1):
                answer+=1 
                reserve.pop(j)
                break
                
    return answer