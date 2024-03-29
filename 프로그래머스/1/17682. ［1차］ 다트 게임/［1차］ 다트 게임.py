def solution(dartResult):
    numberarr = ['0','1','2','3','4','5','6','7','8','9']
    pointarr = []
    cnt = 0
    for i in range(len(dartResult)) : 
        now = dartResult[i]
        
        if now == '1' and dartResult[i+1] == '0' :
            cnt = cnt + 10
            continue
        
        elif now in numberarr : 
            cnt = cnt + int(now)
            continue
            
        if now == 'S' :
            pointarr.append(cnt)
        elif now == 'D' :
            pointarr.append(cnt**2)
        elif now == 'T':
            pointarr.append(cnt**3)
        
        elif now == '#' :
            pointarr[-1] = pointarr[-1]* (-1)
        elif now == '*':
            if len(pointarr) == 1:
                pointarr[-1] = pointarr[-1] *2 
            else :
                pointarr[-1] = pointarr[-1]*2
                pointarr[-2] = pointarr[-2]*2
        
        
        cnt = 0
        
    return sum(pointarr)     
        
 