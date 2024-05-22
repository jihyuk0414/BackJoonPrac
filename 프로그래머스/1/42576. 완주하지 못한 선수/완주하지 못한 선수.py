def solution(participant, completion):
    answer = ''
    answerstack = {}
    for i in participant:
        if i in answerstack.keys() :
            answerstack[i] +=1 
        else:
            answerstack[i] = 1
        
    for j in completion :
        if j in answerstack.keys() :
            answerstack[j] -=1
            
    for i in answerstack :
        if answerstack[i] != 0 :
            return i
    