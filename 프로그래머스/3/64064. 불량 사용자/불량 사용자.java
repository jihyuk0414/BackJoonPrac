import java.util.*;
class Solution {
    
    public int n,m,answer;
    public Set<String> answerset = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        n = user_id.length;
        m = banned_id.length;
        //백트래킹
        boolean [] visited = new boolean[n];
        backtracking(banned_id, user_id, visited,0, new ArrayList<>());
        
        return answerset.size();
    }
    
    public void backtracking(String [] banned_id, String [] user_id, boolean [] visited, int depth, List<Integer> canbe)
    {
        if (depth == m)
        {
            //도달했다고 다 되는게아니고, frodocrodo겹치는애는 안되네.
    List<Integer> sortedCopy = new ArrayList<>(canbe);
    Collections.sort(sortedCopy);
    
    StringBuilder sb = new StringBuilder();
    for (Integer val : sortedCopy) {
        sb.append(String.valueOf(val));
    }
    answerset.add(sb.toString());
            return;
        }
        
        for (int i=0; i<n; i++)
        {
            if (!visited[i])
            {
                //검사하고
                if (check(banned_id[depth],user_id[i]))
                {
                    visited[i] = true;
                    canbe.add(i);
                    backtracking(banned_id,user_id,visited,depth+1,canbe);
                    visited[i] = false;
                    canbe.remove(canbe.size()-1);
                }
            }
        }
    }
    
    public boolean check(String target, String now)
    {
        if (target.length() != now.length())
        {
            return false;
        }
        
        for (int i = 0 ; i<now.length(); i++)
        {
            if (target.charAt(i) == '*')
            {
                continue;
            } else {
                if (target.charAt(i) != now.charAt(i))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}