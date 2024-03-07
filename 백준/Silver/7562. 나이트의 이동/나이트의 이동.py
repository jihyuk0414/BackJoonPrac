import sys
from collections import deque
N = int(sys.stdin.readline().strip())


nx = [1, 2, 2, 1, -1, -2, -2, -1]
ny = [-2, -1, 1, 2, -2, -1, 1, 2]

def BFS(x,y):

    q= deque()

    q.append([x,y])

    while q:
        fromnode = q.popleft()
        fromx = fromnode[0]
        fromy = fromnode[1]

        if (fromx == endx and fromy == endy) :
            return graph[endx][endy]

        
        for i in range(8):
            dx = fromx + nx[i]
            dy = fromy + ny[i]
            
            if 0 <= dx < length and 0 <= dy <length :
                if graph[dx][dy] == 0:
                    q.append([dx, dy])
                    graph[dx][dy] = graph[fromx][fromy] + 1  # 수정된 부분
                    
                        


for i in range(N):
    length = int(sys.stdin.readline())
    startx, starty = map(int, sys.stdin.readline().split())
    endx, endy = map(int, sys.stdin.readline().split())

    graph = [[0] * (length + 1) for _ in range(length + 1)]
    print(BFS(startx, starty))

