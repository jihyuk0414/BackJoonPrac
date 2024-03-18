from collections import deque

def BFS(x,y,maps) :
    nx = [-1,1,0,0]
    ny = [0,0,-1,1]
    
    M = len(maps)
    N = len(maps[0])
    
    q= deque()
    q.append([x,y])
    
    graph = [ [True] * N for _ in range(M)]
    
    graph[0][0] = False
    
    while q:  
        poparr = q.popleft()
        xstart = poparr[0]
        ystart = poparr[1]
        
        for i in range(4) :
            dx = xstart+nx[i]
            dy = ystart+ny[i]
        
            if (0<=dx<M and 0<=dy<N) and maps[dx][dy] == 1 :
                if graph[dx][dy] == True  :
                    graph[dx][dy] = False
                    maps[dx][dy]= maps[xstart][ystart]+1
                    q.append([dx,dy])
                
        
    if maps[M-1][N-1] != 1 :
        return maps[M-1][N-1]
    else :
        return -1
              

def solution(maps):
    
    return BFS(0,0,maps)    