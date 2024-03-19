def solution(number, k):
    answer = []
    
    for num in number:
        while answer and answer[-1]<num and k>0 :
            answer.pop()
            k = k -1
        
        answer.append(num)
    if k>0 :
        return ''.join(answer[0:len(answer)-k])
    else:
        return ''.join(answer)