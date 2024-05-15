def solution(elements):
    answerlist = []
    newel= elements*2
    
    #2개
    for i in range(1,len(elements)) :
        for j in range(0,len(elements)):
            answerlist.append(sum(newel[j:j+i]))
    answerlist.append(sum(elements))
            
    answer = len(set(answerlist))
    
    return answer