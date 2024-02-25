import sys

N = int(sys.stdin.readline())

Narr = []

for i in range(N) :
    Narr.append(list(map(int,sys.stdin.readline().strip())))



def DFS(x,y,size) :
    global answerarr

    color = Narr[x][y]

    for i in range(x,x+size) :
        for j in range(y,y+size) :
            if Narr[i][j] != color:
                print("(",end= "")
                DFS(x,y,size//2)
                DFS(x,y+size//2,size//2)
                DFS(x+size//2,y,size//2)
                DFS(x+size//2,y+size//2,size//2)
                print(")",end= "")
                return

    if color == 0 :
        print("0", end= "")
        return

    else:
        print("1", end= "")

        return

DFS(0,0,N)