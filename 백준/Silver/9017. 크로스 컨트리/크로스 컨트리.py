import sys

N = int(input())

while N:

    trash = int(input())
    Nlist = list(map(int,sys.stdin.readline().split()))
    moresixHash = {}


    #팀별 수 세야지 .
    for nextval in Nlist:
        if nextval in moresixHash :
            moresixHash[nextval] +=1 
        else :
            moresixHash[nextval] = 1

 
    
    nolist = []
    #제외되는 팀 세기
    for i in moresixHash.keys() :
        if moresixHash[i] < 6 :
            nolist.append(i)

    NHash = {}
    nowrank = 1
    for nextteam in Nlist:
        if nextteam not in nolist:
            if nextteam in NHash:
                if NHash[nextteam][0] <4 :
                    NHash[nextteam][0] += 1
                    NHash[nextteam][1] += nowrank
                elif NHash[nextteam][0] == 4 :
                    NHash[nextteam][0] += 1
                    NHash[nextteam][2] = nowrank
            else :
                NHash[nextteam] = [1,nowrank,0]
            nowrank+=1

    
    sorted_teams = sorted(NHash.items(), key=lambda x: (x[1][1], x[1][2]))

    print(sorted_teams[0][0])

    N -= 1 
        