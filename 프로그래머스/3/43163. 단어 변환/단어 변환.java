import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<String [] > q = new LinkedList<>();
        String [] newarr = new String[]{begin,"0"};
        q.add(newarr);
        //q에다 begin을 넣고
        boolean [] visited = new boolean[words.length];
        //words를 돌면서
        while (!q.isEmpty())
        {
            String [] nowarr = q.poll();
            String now = nowarr[0];
            int val = Integer.parseInt(nowarr[1]);
            
            if(now.equals(target))
            {
                return val;
            }
            
            for (int i = 0 ; i<words.length; i++)
            {
                String word = words[i];
                if (!visited[i] && onediff(now,word))
                { 
                    visited[i] = true;
                    String cntstr = String.valueOf(val+1);
                    q.add(new String [] {word,cntstr});
                }
            }
        }
        
        
        return 0;
    }
    
    public boolean onediff (String source, String target)
    {
        int cnt = 0;
        for (int i = 0 ; i<target.length(); i++)
        {
            if(source.charAt(i) != target.charAt(i))
            {
                cnt +=1;
            }
        }
        
        if (cnt == 1)
        {
            return true;
        } else {
            return false;
        }
    }
}