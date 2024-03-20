from collections import deque

def solution(priorities, location):
    queue =  [(i,p) for i,p in enumerate(priorities)]
    answer =0 
    while queue :
        firstone = queue.pop(0)
        if any(firstone[1] < p[1] for p in queue) :
            queue.append(firstone)
        else :
            answer+=1 #작업진행
            if firstone[0] == location:
                return answer