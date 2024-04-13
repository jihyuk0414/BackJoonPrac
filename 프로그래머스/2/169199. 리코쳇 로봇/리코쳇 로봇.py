from collections import deque

def solution(board):
    answer = 0
    graph = []

    length = [[100000000] * len(board[0]) for _ in range(len(board))]
    
    q = deque()
    
    for i in range(len(board)) :
        for j in range(len(board[0])) :
            if board[i][j] == 'R' :
                q.append([i,j,0])
                length[i][j] = 0 
                break
                break          
                
    
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    while q :
        x,y,c = q.popleft()
        
        if board[x][y] == 'G':
            return c
        
        for i in range(4) :
            nx = x
            ny = y
            while 0<=nx+dx[i]<len(board) and 0<=ny+dy[i]<len(board[0]) and board[nx+dx[i]][ny+dy[i]] != 'D' :
                nx = nx + dx[i]
                ny = ny + dy[i]
                
            if length[nx][ny]>c+1 :
                #도착했어요. 근데 지금 온 길이 더 짧네요. 
                length[nx][ny] = c+1 
                q.append([nx,ny,c+1])
            
    
    
    return -1