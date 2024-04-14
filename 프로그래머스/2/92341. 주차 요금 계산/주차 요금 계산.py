import math
def solution(fees, records):

    timeleft = {}
    
    for i in records: 
        time,carnum,state = i.split()
        if carnum not in timeleft.keys() :
            timeleft[carnum] = fees[0]#기본 주차 가능 시간 
            
    parkinglot = []
    timeremember = {}
    for i in records:
        time,carnum,state = i.split()
        realtime = int(time[0:2])*60 + int(time[3:])
        
        if state == "IN" :
            parkinglot.append(carnum)
            timeremember[carnum] = realtime
        
        else :
            #나갈때가 되었어요 . 
            parkinglot.remove(carnum)
            howmanytime = realtime-timeremember[carnum] #시간 차이
            timeleft[carnum] -= howmanytime
            
    # print(parkinglot) #아직 안빠진 애가 있다?
    
    if len(parkinglot) >0 :
        for left in parkinglot :
            beforetime = timeremember[left] 
            timeleft[left] -= (1439 - beforetime ) # 다 정산 완료 #여기가좀이상.
            
    print(timeleft)
    
    paydict = {}      
        
    for i in timeleft:
        if timeleft[i] >= 0 :
            paydict[i] = fees[1]
        elif timeleft[i]< 0 :
            cost = fees[1]+ math.ceil((-timeleft[i])/fees[2])*fees[3]
            paydict[i] = cost
            
    new = sorted(paydict.items(),key= lambda x:x[0])
    
    answer = []
    
    for i in new :
        answer.append(i[1])
   
    return answer