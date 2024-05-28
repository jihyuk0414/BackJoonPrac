def solution(dirs):
    answer = 0
    
    answerlist = []
    x = 0
    y = 0 
    nx = 0
    nx = 0
    for i in range(len(dirs)) :
        
        w = dirs[i]
        if w == 'U':
            nx, ny = x-1, y
        elif w == 'D':
            nx, ny = x+1, y   
        elif w == 'R':
            nx, ny = x, y + 1  
        elif w == 'L':
            nx, ny = x, y-1
        
        print(x,y,nx,ny)
            
        if -5<=nx<=5 and -5<=ny<=5 :
            beforex =x 
            beforey = y
            x = nx
            y = ny
            if [beforex,beforey,x,y] not in answerlist and [x,y,beforex,beforey] not in answerlist:
                answerlist.append([beforex,beforey,x,y])
            
        
        else :
            nx = x
            ny = y
        
    print(answerlist)        
        
    return len(answerlist)