def solution(food):
    answer = ''
    onepeoplefood = []
    for i in range(len(food)):
        if food[i]%2 != 0 :
            for j in range(1,food[i]//2+1) :
                onepeoplefood.append(str(i))
        else:
            #잘 나눠질때
            for j in range(1,food[i]//2+1) :
                onepeoplefood.append(str(i))
    
    answer = ''.join(onepeoplefood) +'0' + ''.join(sorted(onepeoplefood,reverse=True))
    
    return answer