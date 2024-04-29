answer = 0 

def DFS(arr, nowpoint,visited,cnt) :

    global answer
    
    for i in range(len(arr)) :
        if nowpoint >= arr[i][0] and visited[i]==False :
            visited[i] = True
            DFS(arr,nowpoint-arr[i][1],visited,cnt+1)
            visited[i] = False
    
    answer = max(answer,cnt)

def solution(k, dungeons):

    visited= [False] * (len(dungeons))
    
    DFS(dungeons,k,visited,0)

    
    return answer