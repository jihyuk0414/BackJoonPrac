import sys
input = sys.stdin.readline

while True :
    try :
        x = int(input()) * 10000000
        N = int(input())

        inputlist = []

        for i in range(N):
            inputlist.append(int(input()))

        inputlist.sort()
        endindex = N - 1
        startindex = 0

        flag=True

        while startindex < endindex:
            sumcnt = inputlist[startindex] + inputlist[endindex]
        
            if sumcnt == x:
                print("yes", inputlist[startindex], inputlist[endindex])
                flag=False
                break
                
            elif sumcnt < x:
                startindex += 1
            else:
                endindex -= 1


        if flag : 
            print("danger")


    
    except :
        break