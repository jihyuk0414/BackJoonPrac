import sys

N = int(sys.stdin.readline())

Nlist = []

for i in range(N) :
    Nlist.append(list(map(int,sys.stdin.readline().split())))


whitesum = 0
bluesum = 0

def DFS(x,y,N) :

    global whitesum
    global bluesum

    color = Nlist[x][y]

    for i in range(x,x+N) :
        for j in range(y,y+N) :
            if Nlist[i][j] != color :
                DFS(x,y,N//2)
                DFS(x+N//2,y,N//2)
                DFS(x,y+N//2,N//2)
                DFS(x+N//2,y+N//2,N//2)
                return 

    if color == 1 :
        bluesum+=1
    else :
        whitesum += 1


DFS(0,0,N)

print(whitesum)
print(bluesum)
        