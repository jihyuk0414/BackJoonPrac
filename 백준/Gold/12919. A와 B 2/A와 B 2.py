import sys

    
S = input()
T = input()

def dfs(arr) :
    if arr == S :
        print(1)
        sys.exit()

    if len(arr) == 0 :
        return 0 

    if arr[-1] == "A" :
        dfs(arr[:len(arr)-1])

    if arr[0] == "B" :
        dfs(arr[1:][::-1])

dfs(T)
print(0)