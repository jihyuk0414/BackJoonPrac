answer = []

def hanoy(n,fromwhere,to,mid) :
    
    global answer
    
    if n ==1 :
        return [[fromwhere,to]]
        return
    
    return hanoy(n-1,fromwhere,mid,to) + [[fromwhere,to]] + hanoy(n-1,mid,to,fromwhere)

def solution(n):
    

    return (hanoy(n,1,3,2))
    

