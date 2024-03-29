def solution(k, tangerine):
    answer = 0
    tangerine.sort()
    typetan = len(set(tangerine))
    countdict = {}
    for i in range(len(tangerine)) :
        if tangerine[i] not in countdict.keys() : 
            countdict[tangerine[i]] = 1
        else:
            countdict[tangerine[i]] +=1 
            
    tangerine.sort(key = lambda x : countdict[x])
  
    length  = len(tangerine)


            
    return len(set(tangerine[length-k:]))