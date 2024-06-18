import sys
from collections import deque

# 입력 받기
N, M = map(int, sys.stdin.readline().split())

nlist = []
for _ in range(M):
    nlist.append(list(map(int, sys.stdin.readline().split())))

# BFS를 위한 큐 초기화 및 방향 벡터
q = deque()
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(M):
    for j in range(N):
        if nlist[i][j] == 1:
            q.append((i, j, 0))  # 위치와 현재 날짜(0일째)를 함께 저장

# BFS 탐색 함수
def BFS():
    max_day = 0  # 토마토가 익는데 걸린 최대 일수
    while q:
        y, x, day = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and nlist[ny][nx] == 0:
                nlist[ny][nx] = 1  # 토마토를 익은 상태로 변경
                q.append((ny, nx, day + 1))
                max_day = day + 1  # 최대 일수 업데이트
    return max_day

# BFS 탐색 실행 및 최대 일수 계산
result = BFS()

# 모든 토마토가 익었는지 확인
all_ripe = True
for row in nlist:
    if 0 in row:
        all_ripe = False
        break

# 결과 출력
if all_ripe:
    print(result)
else:
    print(-1)
