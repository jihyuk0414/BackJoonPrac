def solution(n):
    answer = []
    answerset = set()
    i = 2
    while n>1 :
        if n%i == 0 :
            answerset.add(i)
            n/= i
        else :
            i+=1 
            
    answer = list(answerset)
    answer.sort()
    
    return answer



