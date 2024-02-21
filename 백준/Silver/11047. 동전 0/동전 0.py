import sys

N,K = map(int,sys.stdin.readline().split())

coinlist = []

for i in range (N) :
    coinlist.append(int(sys.stdin.readline()))

coinlist.sort(reverse= True)

start = 0
cnt = 0
while K>0 :

    if coinlist[start]<=K :
        cnt = cnt + K // coinlist[start]
        K = K % coinlist[start]
        continue
    else :
        start+=1
        continue

print(cnt)