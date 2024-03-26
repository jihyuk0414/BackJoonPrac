def solution(ingredient):
    answer = 0

    burgerarr = []
    
    for i in ingredient :
        
        burgerarr.append(i)
        
        if burgerarr[-4:] == [1,2,3,1] :
            answer+=1
            for i in range(4):
                burgerarr.pop()
        
        
                
            
    return answer