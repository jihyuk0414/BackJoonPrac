def solution(participant, completion):
    answer = ''
    
    participant.sort()
    completion.sort()
    
    for i in range(0,len(participant)-1) :
        if participant[i] != completion[i]:
            return participant[i]
    
    return participant[-1]
    