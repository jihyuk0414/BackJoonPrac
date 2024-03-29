import math

def solution(n, words):
    answer = []
    talk = []
    for i in range(len(words)) : 
        if i == 0 :
            talk.append(words[i])
            continue
        if (words[i] not in talk) and words[i][0] == words[i-1][-1] :
            talk.append(words[i])
            continue
        else :
            #talk에 있거나 끝말잇기가 안되었거나 
            answer.append((i%n)+1)
            answer.append((i//n)+1)
            break
    
    if len(answer) == 0 :
        answer.append(0)
        answer.append(0)
        
    return answer
            
    