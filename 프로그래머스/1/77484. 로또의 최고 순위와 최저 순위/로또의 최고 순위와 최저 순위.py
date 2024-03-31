def solution(lottos, win_nums):
    answer = []
    correct = 0 
    for i in win_nums :
        if i in lottos :
            correct+= 1
    zero_count = lottos.count(0)
    
    mincorrect = 0
    maxcorrect = 0 
    if zero_count != 0 :
        mincorrect = correct 
        maxcorrect = correct +zero_count
    else :
        mincorrect = correct 
        maxcorrect = correct
    
    maxrank = 0 
    minrank = 0
    
    if maxcorrect == 6 :
        maxrank = 1
    elif maxcorrect == 5 :
        maxrank = 2
    elif maxcorrect == 4 :
        maxrank = 3
    elif maxcorrect == 3 :
        maxrank = 4
    elif maxcorrect == 2 :
        maxrank = 5
    else :
        maxrank = 6
        
    if mincorrect == 6 :
        minrank = 1
    elif mincorrect == 5 :
        minrank = 2
    elif mincorrect == 4 :
        minrank = 3
    elif mincorrect == 3 :
        minrank = 4
    elif mincorrect == 2 :
        minrank = 5
    else :
        minrank = 6
        
    return [maxrank,minrank]

