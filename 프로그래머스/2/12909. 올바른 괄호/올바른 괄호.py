
def solution(s):
    answer = True
    answerq = [] #(만담자
    
    for i in range(len(s)):
        if len(answerq) == 0 and s[i]=="(" :
            answerq.append(s[i])
        elif len(answerq) == 0 and s[i]==")" :
            answer=False
            break
            
        elif s[i] == "(" :
            answerq.append(s[i])
        
        elif s[i] == ")" :
            answerq.pop()
            
    if len(answerq) != 0 :
        answer = False
        

    
    return answer