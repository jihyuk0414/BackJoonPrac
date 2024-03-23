def solution(clothes):
    answer = 1
    clothdict = {}
    for i in clothes :
        if i[1] in clothdict.keys() : 
            clothdict[i[1]] += 1
        else :
            clothdict[i[1]] =1
    
    for i in clothdict : 
        answer = answer * (clothdict[i]+1)

    answer = answer -1 
    
    return answer