answer = 0 

def DFS(k,cnt,dungeons,dungeonnumber,graph) :
    
    global answer
     
    
    if cnt > answer:
        answer = cnt 
    
    
    for i in range(0,dungeonnumber) :
        if (graph[i] == 0) and (dungeons[i][0] <= k) :
            graph[i]= 1
            DFS(k-dungeons[i][1],cnt+1,dungeons,dungeonnumber,graph)
            graph[i]= 0 
    return


def solution(k, dungeons):
    dungeonnumber = len(dungeons)
    graph = [0] * dungeonnumber
    
    DFS(k,0,dungeons,dungeonnumber,graph)
         
    return answer