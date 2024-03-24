def solution(n, k):
    if n == 1 :
        return 0
    
    kzinsu = ''
    
    while n>0 : 
        kzinsu = str(n%k) + kzinsu
        n = n //k
    
    kzinsu = kzinsu.split('0')
    result = 0
 
    
    for i in kzinsu:
        if len(i) ==  0:
            continue
        if int(i) <2 :
            continue
        else :
            teni = int(i)
            sosu = True
            for j in range(2,int(teni**(0.5)+1)) :
                if teni % j == 0:
                    sosu=False
                    break

            if sosu == True:
                result+=1

        

    return result