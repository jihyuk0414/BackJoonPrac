import sys

N= sys.stdin.readline().strip()

M = N.split('-')

answer = 0

x= sum(map(int,(M[0].split('+'))))
if N[0] == "-" :
    answer = answer-x
else:
    answer = answer+x

for x in M[1:] :

    x = sum(map(int, (x.split('+'))))
    answer = answer-x

print(answer)