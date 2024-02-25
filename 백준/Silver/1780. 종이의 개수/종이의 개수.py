import sys

N = int(sys.stdin.readline())

Narr = []

for i in range(N) :
    Narr.append(list(map(int,sys.stdin.readline().split())))

zerosum= 0
onesum= 0
minussum = 0

def DFS(x,y,N) :

    global zerosum
    global onesum
    global minussum

    color = Narr[x][y]

    for i in range(x,x+N) :
        for j in range(y,y+N) :

            if Narr[i][j] != color :
                DFS(x,y,N//3)
                DFS(x+N//3,y,N//3)
                DFS(x+(N//3)*2,y,N//3)
                DFS(x,y+N//3,N//3)
                DFS(x,y+(N//3)*2,N//3)
                DFS(x+N//3,y+N//3,N//3)
                DFS(x+N//3,y+(N//3)*2,N//3)
                DFS(x+N//3*2,y+(N//3),N//3)
                DFS(x+(N//3)*2,y+(N//3)*2,N//3)
                return
    if color == 1 :
        onesum += 1
        return

    elif color == -1 :
        minussum += 1
        return

    else :
        zerosum += 1
        return

DFS(0,0,N)
print(minussum)
print(zerosum)

print(onesum)


