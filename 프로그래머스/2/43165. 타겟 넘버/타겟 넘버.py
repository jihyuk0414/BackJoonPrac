import sys
sys.setrecursionlimit(10000000)

cnt = 0

def DFS(x,totalval,numbers,target) :
    global cnt 
    

    
    if x == len(numbers):
        if totalval == target :
            cnt+=1
            return
    
    if (0<=x<len(numbers)) :
        DFS(x+1,totalval+numbers[x],numbers,target)
        DFS(x+1,totalval-numbers[x],numbers,target)
    return

def solution(numbers, target):
    global cnt 
    DFS(0,0,numbers,target)
    return cnt
    
    #여기가 일반 바닥이라고 생각하자 . input은 받은거야
    

    
    