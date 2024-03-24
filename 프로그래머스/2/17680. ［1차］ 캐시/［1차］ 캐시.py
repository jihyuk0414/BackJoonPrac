def solution(cacheSize, cities):
    answercache = []
    point = 0
    
    if cacheSize == 0 :
        return len(cities)*5
    
    for i in range(len(cities)) : 
        
        if cities[i].upper() in answercache : 
            point+=1 
            changevalue = answercache.pop(answercache.index(cities[i].upper()))
            answercache.append(changevalue)
            continue
        else : 
            #없다
            if (len(answercache) ==0) or (len(answercache) < cacheSize) :
                answercache.append(cities[i].upper())
                point+= 5 

            else:
                answercache.pop(0)
                answercache.append(cities[i].upper())
                point+= 5 

                
    return point