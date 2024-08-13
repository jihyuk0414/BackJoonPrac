import sys

firstinputarr = list(map(str, sys.stdin.readline().split()))
inputarr = []

# Convert time strings to minutes since start of the day
for time_str in firstinputarr:
    hours, minutes = map(int, time_str.split(':'))
    total_minutes = hours * 60 + minutes
    inputarr.append(total_minutes)

S = inputarr[0]
E = inputarr[1]
Q = inputarr[2]

comparedict = {}

answer = 0 
answerset= set([])


for line in sys.stdin:
    onepeopleinput = list(map(str, line.split()))
    onepeoplename = onepeopleinput[1]


    onepeoplehour = int(onepeopleinput[0][0])*10*60 + int(onepeopleinput[0][1])*60
    onepeopleminute = int(onepeopleinput[0][3])*10 + int(onepeopleinput[0][4])
    onepeopletime = onepeoplehour+onepeopleminute

    if onepeopletime <= S :
          comparedict[onepeoplename] = 0 

    elif E <= onepeopletime<= Q :
          if onepeoplename in comparedict.keys() :
             answerset.add(onepeoplename)
             answer+=1

print(len(answerset))







