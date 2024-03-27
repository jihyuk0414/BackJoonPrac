def solution(n):
    answer = 0
    nlist = [i for i in range(n+1)]
    print(nlist)
    
    for i in range(1,n) :
        sumnum = 0 
        for j in range(i,n) :
            sumnum+= j
            if sumnum == n :
                answer+= 1
                break
            elif sumnum > n :
                break
    
    return answer+1