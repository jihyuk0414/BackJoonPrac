def solution(keymap, targets):
    answer = []
    answerdict = {}
    for i in range(len(keymap)) :
        for j in range(len(keymap[i])) :
            if keymap[i][j] not in answerdict:
                answerdict[keymap[i][j]] = []
            
            answerdict[keymap[i][j]].append(j+1)
    
    
    for i in range(len(targets)) :
        value = 0
        for j in range(len(targets[i])) :
            if targets[i][j] not in answerdict :
                value = -1
                break
            else:
                value+= min(answerdict[targets[i][j]])
        answer.append(value)
    
    return answer