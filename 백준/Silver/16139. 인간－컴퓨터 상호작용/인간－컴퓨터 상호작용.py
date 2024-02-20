import sys

S = sys.stdin.readline().strip()
#입력받는 문자열임

Q = int(sys.stdin.readline())

for i in range(Q) :
 a,lin,rin = sys.stdin.readline().split()
 l = int(lin)
 r = int(rin)
 sum = 0
 for j in range(l,r+1) :
     if S[j] == a :
         sum += 1
 print(sum)
