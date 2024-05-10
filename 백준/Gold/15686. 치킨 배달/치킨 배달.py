from itertools import combinations
import sys

N,M = map(int,sys.stdin.readline().split())

graph = []
for i in range(N):
    graph.append(list(map(int,sys.stdin.readline().split())))

house = []
chicken = []

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1 :
            house.append([i,j])
        elif graph[i][j]==2:
            chicken.append([i,j])

answer = N*N*N
for comb in list(combinations(chicken, M)):
    totallen = 0
    for home in house:
        ptplen = N*N

        for x,y in comb :
            ptplen = min(ptplen,abs(home[0]-x)+abs(home[1]-y))

        totallen+=ptplen
    answer = min(answer,totallen)
            
        
print(answer)
