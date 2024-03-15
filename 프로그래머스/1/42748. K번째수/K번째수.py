def solution(array, commands):
    answer = []
    
    i=0
    j=0
    k=0
    
    for x in range (len(commands)) :
        i = commands[x][0]
        j = commands[x][1]
        k = commands[x][2]
        
        answerarr=sorted(array[i-1:j])
        
        answer.append(answerarr[k-1])
    
    
    
    return answer