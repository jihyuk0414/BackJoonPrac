import sys
sys.setrecursionlimit(1000000)

nx = [-1, 1, 0, 0]
ny = [0, 0, -1, 1]

def DFS(x, y):
    global Nlist
    global H
    global W

    Nlist[x][y] = '.'

    for i in range(4):
        dx = x + nx[i]
        dy = y + ny[i]

        if (0 <= dx < H) and (0 <= dy < W):
            if Nlist[dx][dy] == '#':
                Nlist[dx][dy] = '.'
                DFS(dx, dy)

N = int(input())
for _ in range(N):
    H, W = map(int, input().split())
    Nlist = [list(input().strip()) for _ in range(H)]  # strip()을 사용하여 개행문자를 제거합니다.

    cnt = 0
    for i in range(H):
        for j in range(W):
            if Nlist[i][j] == '#':
                DFS(i, j)
                cnt += 1
    print(cnt)