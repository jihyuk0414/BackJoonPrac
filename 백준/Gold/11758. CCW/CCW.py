import sys


#리스트가 [x,y]
Nlist = []
for i in range(3):
    Nlist.append(list(map(int,sys.stdin.readline().split())))

x1,y1 = Nlist[0][0],Nlist[0][1]
x2,y2 = Nlist[1][0],Nlist[1][1]
        
x3,y3 = Nlist[2][0],Nlist[2][1]

temp = x1*y2+x2*y3+x3*y1 - (x2*y1+x3*y2+x1*y3)

if temp>0 :
    print(1)
elif temp == 0:
    print(0)
else:
    print(-1)
    
