def solution(board, h, w):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    x =h
    y = w
    color = board[h][w]
    answer = 0
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0<=nx<len(board) and 0<=ny<len(board[0]) :
            if board[nx][ny] == color:
                answer+=1
    return answer