def solution(wallpaper):

    lux = 0
    luy = 1000000 
    rdx = 0
    rdy = 0 #rdxrdy는 1개 추가해줘야함. 
    luxcandidate = []
    rdycandidate = []
    for i in range(len(wallpaper)) :
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#' :
                luxcandidate.append(i)
                luy = min(luy,j)
                rdx = max(rdx,i)
                rdycandidate.append(j)
    luxcandidate.sort() 
    rdycandidate.sort(reverse=True)
    
    lux = luxcandidate[0]
    rdy = rdycandidate[0]
    
    answer = [lux,luy,rdx+1,rdy+1]
    

    
    return answer