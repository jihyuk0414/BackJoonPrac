def DFS(board,x,y) :
    
    if board[x][y] == 1 :
        dx = [-1,-1,-1,0,0,0,1,1,1]
        dy = [-1,0,1,-1,0,1,-1,0,1]
        
        for i in range(9):
            nx = x+dx[i]
            ny = y+dy[i]
            
            if 0<=nx<len(board[0]) and 0<=ny<len(board[0]):          
                if board[nx][ny] == 0:
                    board[nx][ny] = 2 
            else:
                continue
        
        board[x][y] = 2 
            
        
        
        

def solution(board):
    n = len(board)
    total = n*n
    visited = [ [False] * (n) for _ in range(n)]
    
    for i in range(n) :
        for j in range(n):
            DFS(board,i,j)
            
    onecnt = 0 
    
    for i in range(n):
        onecnt+= board[i].count(2)
    
    print(board)
    
    return total - onecnt

    
