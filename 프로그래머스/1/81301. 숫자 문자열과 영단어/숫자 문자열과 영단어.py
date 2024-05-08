def solution(s):
    answerarr =[]
    answerdict = {"zero": 0, "one": 1, "two": 2, "three": 3, "four": 4, "five": 5, "six": 6, "seven": 7, "eight": 8, "nine": 9}
    numberarr = ["0","1","2","3","4","5","6","7","8","9"]
    
    i= 0
    comparestr = ""
    while (i<len(s)) :
        comparestr = comparestr+s[i]

        if comparestr in answerdict.keys() :
            answerarr.append(answerdict[comparestr])
            comparestr = ""
            
            
        elif comparestr in numberarr :
            answerarr.append(int(comparestr))
            comparestr = ""
            
        i+=1
    
    answer= ""
    for i in range(len(answerarr)):
        answer += str(answerarr[i])
    
    return int(answer)