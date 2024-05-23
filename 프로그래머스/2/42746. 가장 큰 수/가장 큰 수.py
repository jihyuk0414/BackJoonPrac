def solution(numbers):
    strnumbers = list(map(str,numbers))
    strnumbers.sort(reverse=True, key = lambda x : x*3)
    answer = str(int(''.join(map(str,strnumbers))))
    return answer