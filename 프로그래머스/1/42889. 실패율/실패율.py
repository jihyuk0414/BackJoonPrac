def solution(N, stages):
    stages.sort()
    answer = []
    fail = {}
    player = len(stages)
    
    for i in range(1,N+1) :
        if player == 0 :
            fail[i] = 0 
        else:
            fail[i] = stages.count(i) / player
            player = player - stages.count(i)
            
    answeritem = sorted(fail.items(), key = lambda x: x[1], reverse=True)
    
    for i in range(len(answeritem)):
        answer.append(answeritem[i][0])

        
    return answer