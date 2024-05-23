def solution(arr):
    answer = []
    
    for i in range(len(arr)) :
        if len(answer) == 0 :
            answer.append(arr[i])
            continue
        
        if arr[i] == answer[-1] :
            continue
        else :
            answer.append(arr[i])
        
        
    
    return answer