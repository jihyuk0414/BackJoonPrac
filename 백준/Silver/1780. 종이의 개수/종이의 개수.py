import sys

N = int(input())

graph = []

for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().split())))


#분할 정복

onecnt =0
zerocnt =0
minuscnt = 0

def divide(row,col,size) :

    global zerocnt
    global onecnt
    global minuscnt

    color = graph[row][col]

    for i in range(row,row+size):
        for j in range(col,col+size):

            if graph[i][j] != color :
                #색이 다르다?

                divide(row,col,size//3)
                divide(row+size//3,col,size//3)
                divide(row+size//3*2,col,size//3)

                divide(row,col+size//3,size//3)
                divide(row,col+size//3*2,size//3)

                divide(row+size//3,col+size//3,size//3)
                divide(row+size//3,col+size//3*2,size//3)

                divide(row+size//3*2,col+size//3,size//3)
                divide(row+size//3*2,col+size//3*2,size//3)
                return

    #문제가 없다면
    if color == 0 :
        zerocnt +=1
    elif color == 1:
        onecnt+=1
    else:
        minuscnt+=1

divide(0,0,N)

print(minuscnt)
print(zerocnt)
print(onecnt)