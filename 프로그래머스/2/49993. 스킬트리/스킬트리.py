def solution(skill, skill_trees):
    answer = 0
    skilllist = list(skill)
    
    for i in range(len(skill_trees)) :
        skillstack = skilllist.copy()
        checkskill = True
        
        for j in range(len(skill_trees[i])) :
            
            if skill_trees[i][j] in skill :
                #있긴 있다
                if skillstack[0] == skill_trees[i][j] :
                    #잘맞는다
                    skillstack.pop(0)
                    if len(skillstack) == 0 :
                       break
                
                else: #있긴한데, 번호가 안맞다.
                    checkskill = False
                    break
        
        if checkskill == True:
                answer+=1

                
        
    return answer