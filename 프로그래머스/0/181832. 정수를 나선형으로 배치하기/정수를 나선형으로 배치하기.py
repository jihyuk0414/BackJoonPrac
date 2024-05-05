def solution(n):
    answer = [[0 for i in range(n)] for _ in range(n)]
    
    x = 0
    y= 0
    where = 'r' #다음에 어디로갈건지
    
    
    for i in range(1,n*n+1):
        answer[x][y]=i
        if n ==1:
            break
        
        if where == 'r':
            y+=1
            if y == n-1 or answer[x][y+1] !=0 :
                where = 'd'
                
                
        elif where == 'd':
            x+=1
            if x == (n-1) or answer[x+1][y] !=0 :
                where = 'l'
                
        
        elif where== 'l' :
            y-=1
            if y == 0 or answer[x][y-1] != 0 :
                where = 'u'
                
                
        elif where== 'u' :
            x-=1
            if x == 0 or answer[x-1][y] != 0 :
                where = 'r'
               
    return answer