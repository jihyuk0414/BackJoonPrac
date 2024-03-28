def solution(n):

    ncount = bin(n).count('1')
    nextn  = n+1 

    
    while True : 
        if bin(nextn).count('1') == ncount : 
            return nextn
        else :
            nextn = nextn+1
