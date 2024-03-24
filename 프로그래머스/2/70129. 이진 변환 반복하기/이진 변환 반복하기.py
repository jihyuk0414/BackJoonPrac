def solution(s):
    answer = []
    zerocnt = 0
    cnt = 0
    while len(s)>1 :
        zerocnt+= s.count('0')
        s = s.replace('0','')
        
        c = len(s)
        
        tmp = ''
        while c!=0:
            tmp = str(c%2) + tmp 
            c = c//2
  
        cnt += 1

        s = tmp
      
        

            
    answer.append(cnt)
    answer.append(zerocnt)
        
    
    return answer