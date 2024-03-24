def solution(phone_book):
    
    phone_book.sort()
    
    for i in range(len(phone_book)-1) :
        
        save = phone_book[i]
        comp = phone_book[i+1]
        
        if save == comp[:len(save)] :
            return False

    
    return True