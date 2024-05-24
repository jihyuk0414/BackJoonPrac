answer = 0 
def DFS(startindex,sumcnt,n,numbers,target) :
    #종단 조건
    global answer
    
    if startindex == n-1 :
        #마지막이고
        if sumcnt == target :
            answer +=1 
            return
            
    
    if 0<=startindex+1<n :
        DFS(startindex+1,sumcnt+numbers[startindex+1],n,numbers,target)
        DFS(startindex+1,sumcnt-numbers[startindex+1],n,numbers,target)

        

def solution(numbers, target):
    n = len(numbers) 
    DFS(-1,0,n,numbers,target)
    return answer

