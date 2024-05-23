import heapq

def solution(scoville, K):
    
    heap = []
    
    for i in scoville :
        heapq.heappush(heap,i)
        
    if heap[0] >= K :
        
        return 0
    
    cnt = 0
    while True :
        
        cnt += 1
        
        if len(heap) == 1 :
            return -1 
        else :
            x = heapq.heappop(heap)
            y = heapq.heappop(heap)
            heapq.heappush(heap,x+2*y)
            
        if heap[0] >= K :
            return cnt
        
        
        
    
        
        
    
    