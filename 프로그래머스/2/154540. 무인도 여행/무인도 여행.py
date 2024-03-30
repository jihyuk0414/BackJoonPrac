import sys
sys.setrecursionlimit(1000000)

def DFS(maps,x,y,cnt):
    
    cnt = int(maps[x][y])
    
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    maps[x][y] = 'X'
    
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        
        if  0<=nx< len(maps) and 0<=ny<len(maps[0]) and maps[nx][ny] != 'X':
            plus = int(maps[nx][ny])
            cnt += DFS(maps,nx,ny,cnt+plus)
            
    
    return cnt   
    

def solution(maps):
    answer = []
    
    realmaps = []
    for i in range(len(maps)) :
        realmaps.append(list(maps[i]))

    
    for i in range(len(realmaps)) :
        for j in range(len(realmaps[0])):
            if realmaps[i][j] != 'X':
                an = DFS(realmaps,i,j,int(realmaps[i][j]))
                if an == 0 :
                    continue
                else:
                    answer.append(an)
    if len(answer) == 0 :
        return [-1]
    else :
        return sorted(answer)