def solution(record):
    answer = []
    idtable = {} #id : nickname
    
    realrecord = []
    
    for next in record :
        strtolist = list(map(str,next.split()))
        
        if strtolist[0] == 'Leave':
            state = strtolist[0]
            userid = strtolist[1]
            realrecord.append(next)
                  
        else:           
            state = strtolist[0]
            userid = strtolist[1]
            nick = strtolist[2]
                  
            if state == 'Enter' :
                  idtable[userid] = nick
                  realrecord.append(next)
        
            elif state == 'Change' :
                  idtable[userid] = nick

                    

    for next in realrecord :
        strtolist = list(map(str,next.split()))

     
        if strtolist[0] == 'Leave':
            state = strtolist[0]
            userid = strtolist[1]
            answer.append("{}님이 나갔습니다.".format(idtable[userid]))
                  
        if strtolist[0] == 'Enter' :     
            state = strtolist[0]
            userid = strtolist[1]
            answer.append("{}님이 들어왔습니다.".format(idtable[userid]))
    
    
    return answer
                  
            

        

        