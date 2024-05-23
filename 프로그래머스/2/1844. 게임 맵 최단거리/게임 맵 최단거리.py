from collections import deque

def solution(maps):
    visited = [[False] * len(maps[0]) for i in range(len(maps))]
    print(visited)
    
    q = deque()
    dx = [-1,1,0,0]
    dy= [0,0,-1,1]
    q.append([0,0,0])
    
    while q :
        movelist = q.popleft()
        x = movelist[0]
        y = movelist[1]
        cnt = movelist[2]
        
        if (x == len(maps)-1) and (y == len(maps[0])-1) :
            return cnt+1
        
        for i in range(4) :
            nx = x+dx[i]
            ny = y+dy[i]
            
            if 0<=nx<len(maps) and 0<=ny<len(maps[0]) and visited[nx][ny] == False:
                #방문안했을때
                if maps[nx][ny] == 1 :
                    visited[nx][ny] = True
                    q.append([nx,ny,cnt+1])
                    
    return -1
                    
      