def solution(str1, str2):
    strset1 = []
    for i in range(0,len(str1)-1):
        if str1[i:i+2].isalpha():
            strset1.append(str(str1[i:i+2]).upper())
            
    strset2 = []
    for i in range(0,len(str2)-1):
        if str2[i:i+2].isalpha():
            strset2.append(str(str2[i:i+2]).upper())
            
    s1 = strset1.copy()
    s2 = strset2.copy()
            
    interset = []
    
    for i in strset1:
        if i in s2 :
            interset.append(i)
            s2.remove(i)
            s1.remove(i)
    
    unionset = []
    
    unionset = s1+s2+interset

    print(unionset,interset)
    answer = 0 
    if len(unionset) == 0 and len(interset) == 0:
        answer = 1*65536
    else :
        answer = int(len(interset)/len(unionset)*65536)
        
        
    return answer
                
  
                