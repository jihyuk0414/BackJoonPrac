import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = []

for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

maxcnt = 0
answer = 0

def BFS(startx, starty):
    global maxcnt
    global answer

    visited = [[False] * M for _ in range(N)]
    q = deque()
    q.append([startx, starty, 0])
    visited[startx][starty] = True

    nx = [-1, 1, 0, 0]
    ny = [0, 0, -1, 1]

    while q:
        mylist = q.popleft()
        x = mylist[0]
        y = mylist[1]
        cnt = mylist[2]
        doyougo = False

        for i in range(4):
            dx = x + nx[i]
            dy = y + ny[i]

            if 0 <= dx < N and 0 <= dy < M and graph[dx][dy] > 0 and not visited[dx][dy]:
                doyougo = True
                visited[dx][dy] = True
                q.append([dx, dy, cnt + 1])

        if not doyougo:
            # 더 갈 곳이 없다면
            if maxcnt < cnt:
                maxcnt = cnt
                answer = graph[startx][starty] + graph[x][y]

            elif maxcnt == cnt:
                
                answer = max(answer, graph[startx][starty] + graph[x][y])

for i in range(N):
    for j in range(M):
        if graph[i][j] > 0:
            BFS(i, j)

print(answer)
# 출발지 0이 아니어야.
