def solution(survey, choices):
    answerdict = {'R':0,'T':0, 'C':0,'F':0,'J':0,'M':0,'A':0,'N':0 }
    answer = ''
    for i in range(len(survey)) :
        if choices[i] ==1  :
            answerdict[survey[i][0]] += 3
        elif choices[i] == 2 :
            answerdict[survey[i][0]] += 2
        elif choices[i] == 3 :
            answerdict[survey[i][0]] += 1
        elif choices[i] == 4 :
            continue
        elif choices[i] == 5 :
            answerdict[survey[i][1]] += 1
        elif choices[i] == 6 :
            answerdict[survey[i][1]] += 2
        elif choices[i] == 7 :
            answerdict[survey[i][1]] += 3
        
            
    if answerdict['R'] == answerdict['T'] :
        answer += 'R'
    elif answerdict['R'] > answerdict['T'] :
        answer += 'R'
    elif answerdict['T'] > answerdict['R'] :
        answer += 'T'
    
            
    if answerdict['C'] == answerdict['F'] :
        answer += 'C'
    elif answerdict['C'] > answerdict['F'] :
        answer += 'C'
    elif answerdict['F'] > answerdict['C'] :
        answer += 'F'
                
    if answerdict['J'] == answerdict['M'] :
        answer += 'J'
    elif answerdict['J'] > answerdict['M'] :
        answer += 'J'
    elif answerdict['M'] > answerdict['J'] :
        answer += 'M'
                
    if answerdict['A'] == answerdict['N'] :
        answer += 'A'
    elif answerdict['A'] > answerdict['N'] :
        answer += 'A'
    elif answerdict['N'] > answerdict['A'] :
        answer += 'N'
                
        
    return answer