def solution(n):
    if n<= 2 :
        return 1 
    
    cnt = 0
    
    while True :
        if n == 2 or n == 1 :
            cnt+= 1
            return cnt
        if n %2 == 0 :
            n = n // 2 
            continue
        else :
            n = n-1 
            cnt += 1
