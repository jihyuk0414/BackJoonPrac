def solution(n,a,b):
    answer = 0
    
    while True:
        if a-1 == 0 :
            a = 1
        else:
            a = (a-1)//2+1
        
        if b-1 == 0 :
            b= 1
        else:
            b= (b-1)//2 +1
    
        answer +=1 
        if a == b :
            return answer

