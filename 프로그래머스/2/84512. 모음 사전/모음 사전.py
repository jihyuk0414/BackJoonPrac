answerlist = []
wordlist = ['A','E','I','O','U']
def DFS(wordlist,before) :
    global answerlist   
    
    if len(before) == 5 :
        return
    
    for i in range(len(wordlist)) :
        answerlist.append(before+wordlist[i])
        DFS(wordlist,before+wordlist[i])
    return

def solution(word):
    
    DFS(wordlist,"")
    
    for i in range(len(answerlist)) :
        if answerlist[i] == word:
            return i+1

    
