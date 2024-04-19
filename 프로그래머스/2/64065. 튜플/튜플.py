def solution(s):
    answerdict = {}
    news = s.replace("{","").replace("}","").split(",")
    for i in news:
        if i in answerdict.keys() :
            answerdict[i]+=1
        else:
            answerdict[i]=1
    realanswerdict=  sorted(answerdict.items(),key=lambda x:x[1],reverse=True)

    answer =[]
    for j in realanswerdict:
        answer.append(int(j[0]))
        
    return answer