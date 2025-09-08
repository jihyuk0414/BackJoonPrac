import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        for (int i = 0 ; i<skill.length(); i++)
        {
            q.add(skill.charAt(i));
        }
        
        for (int i = 0 ; i<skill_trees.length; i++)
        {
            String nowstr = skill_trees[i];
            int nowcompare = 0;
            
            boolean flag = true;
            for (int j = 0 ; j<nowstr.length(); j++)
            {
                if (!q.contains(nowstr.charAt(j)))
                {
                    continue;
                }
                
                if (q.peek() == nowstr.charAt(j))
                {
                    q.poll();
                }
                else
                {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
            {
                answer +=1;
            }
            
             q = new LinkedList<>();
             for (int j = 0 ; j<skill.length(); j++)
             {
                 q.add(skill.charAt(j));
             }
        
        }
        
        return answer;
    }
}