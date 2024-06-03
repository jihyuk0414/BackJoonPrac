def solution(msg):
    # 사전 초기화: A-Z를 1-26으로 매핑
    answerdict = {chr(i): i - 64 for i in range(65, 91)}  # {'A': 1, 'B': 2, ..., 'Z': 26}
    answer = []
    index = 27
    i = 0
    
    while i < len(msg):
        w = msg[i]
        while i + 1 < len(msg) and w + msg[i + 1] in answerdict:
            w += msg[i + 1]
            i += 1
        
        answer.append(answerdict[w])
        if i + 1 < len(msg):
            answerdict[w + msg[i + 1]] = index
            index += 1
        i += 1
    
    return answer