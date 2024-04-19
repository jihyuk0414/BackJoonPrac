def solution(n):
    cntarr = [[1 for i in range(1,j+1)] for j in range(1,n+1)] #그냥 생성
    
    x,y = -1,0
    cnt = 0
    for i in range(n):
        #i는 단순한 횟수, 숫자가 쓰지 않음
        for j in range(i,n):
            
            if i %3 == 0 :
                x+=1
            elif i%3 == 1 :
                y+=1 
            elif i%3 == 2 :
                x-=1
                y-=1
                
            cnt+=1
            cntarr[x][y] = cnt
            
            
    answer = []
    for i in range(len(cntarr)) :
        for j in cntarr[i]:
            answer.append(j)
            
    return answer

        
