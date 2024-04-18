import math

def solution(arr):
    answer = 0
    gndstack = []
    
    for i in range(len(arr)) :
        if i == 0 :
            gndstack.append(arr[i])
            continue
        else:
            compare = gndstack.pop()
            gndstack.append( (compare * arr[i]) // int(math.gcd(compare,arr[i])) )
            
    answer = gndstack[-1]
    return answer