def solution(s):
    slist = list(s)*2
    length = len(s)
    answer = 0 
    for i in range(length) :

        comparelist = slist[i:len(s)+i]
        
        #올바른지만 보면 됨
        
        q =[]
        for j in range(len(comparelist)) :
            if len(q)>0:
                if comparelist[j] == "}" and q[-1] == "{":
                    q.pop()
                elif comparelist[j] == ")" and q[-1] == "(":
                    q.pop()
                elif comparelist[j] == "]" and q[-1] == "[":
                    q.pop()
                else :
                    q.append(comparelist[j])
            
            else : 
                q.append(comparelist[j])
        
        if len(q) == 0:
            answer +=1 
        
    
    return answer