def solution(progresses, speeds):
    answer = []
    day = 0
    while len(progresses)!=0 :
        day+=1
        
        for i in range(len(speeds)) :
            progresses[i]+= speeds[i] #하루마다 추가 .
            
        change= False
        bapocnt =0
        
        if progresses[0] >= 100 : #배포할게 있다면
            while True :
                progresses.pop(0)
                speeds.pop(0)
                bapocnt+=1
                change=True
                    
                if len(progresses) == 0 or progresses[0] < 100 :
                    break
        
        if change == True:
            answer.append(bapocnt)
        
    return answer