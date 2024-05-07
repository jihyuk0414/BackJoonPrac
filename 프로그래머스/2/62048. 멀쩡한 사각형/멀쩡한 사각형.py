import math

def solution(w,h):
    answer = w*h

    minus = math.gcd(w,h)
    if (minus == 1):
        answer = answer-(w+h-1)
    else:
        answer = answer - (w+h-minus)
    
    return answer