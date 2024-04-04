def solution(s, skip, index):
    answer = ''
    alphabat =['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    slist = list(s)
    
    for char in slist :
        
        startindex = alphabat.index(char)
        answercnt =0 
        

        nowindex = startindex 
        
        while answercnt < index :
            
            if nowindex+1 == len(alphabat) :
                #지금 마지막일때. 
                if alphabat[0] not in skip :
                    nowindex=0
                    answercnt+=1 
                    continue
                    if answercnt == index:
                        break
                        
                elif alphabat[0] in skip:
                    nowindex=0 
                    continue
            
            if alphabat[nowindex+1] not in skip :
                #문제 없을땐
                nowindex+=1
                answercnt+=1 
                continue
                
                if answercnt == index:
                    break
                
            elif alphabat[nowindex+1] in skip:
                nowindex+=1 
                continue
                
        answer+= alphabat[nowindex]  
        
    return answer
     
            