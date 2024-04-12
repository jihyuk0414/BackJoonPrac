def solution(book_time):
    answer = 0
    booklist = []
    for i in range(len(book_time)) :
        book_time[i][0]=book_time[i][0][0]+book_time[i][0][1]+book_time[i][0][3]+book_time[i][0][4]
        book_time[i][1]=book_time[i][1][0]+book_time[i][1][1]+book_time[i][1][3]+book_time[i][1][4]

        #:제거했음
    
    book_time.sort(key= lambda x:x[:][0])
    #퇴실이 짧은애부터 정렬
    
    
    print(book_time)
    
    roomlist = []
    for i in range(len(book_time)) :
        if i == 0 :
            roomlist.append(int(book_time[i][1]))
            continue
        else:
            isthere = False
            for j in range(len(roomlist)) :
                nextroom = roomlist[j]+10 
                if nextroom%100 >=60 :
                    nextroom = (nextroom//100+1)*100 + (nextroom%100-60)
                if int(book_time[i][0]) >= nextroom :
                    roomlist[j] = int(book_time[i][1])
                    isthere = True
                    break
            
            if isthere== False:
                roomlist.append(int(book_time[i][1]))
            roomlist.sort()    
                
        
    
    return len(roomlist)