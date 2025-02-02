class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int z = 0 ; z<skill_trees.length; z++)
        {
            String nowstring = skill_trees[z];
            int beforeindex = -1;
            boolean safe = true;
            for (int i = 0 ; i<nowstring.length() ; i++)
            {
                if (skill.contains(nowstring.charAt(i)+""))
                {
                    //조건에 맞는 애들이라면
                    int thatidx = getidx(skill,nowstring.charAt(i));
                    if (thatidx != beforeindex+1)
                    {
                        safe = false;
                        break;
                    } else {
                        beforeindex+=1;
                    }
                }
            }
            if (safe)
            {
                answer +=1;
            }
        }
        return answer;
    }
    
    public int getidx (String compare, char nowchar)
    {
        for (int i = 0 ; i<compare.length() ; i++)
        {
            if (compare.charAt(i) == nowchar)
            {
                return i;
            }
        }
        
        return -1;
    }
}