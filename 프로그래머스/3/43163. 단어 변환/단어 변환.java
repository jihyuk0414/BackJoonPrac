import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Queue<String []> q = new LinkedList<>();
        
        //q에 담아서, string,depth
        String [] first = new String [] {begin,"0"};
        
        boolean [] visited = new boolean[words.length];
        
        q.add(first);
        //가능한 배열 모두 찾아서 . empty면 끝
        while (!q.isEmpty())
        {
            String[] now = q.poll();
            
            if (now[0].equals(target))
            {
                return Integer.parseInt(now[1]);
            }
            
            List<Integer> canbe = canchange(now[0],words);
            if (canbe.size() != 0)
            {
                for (Integer can : canbe)
                {
                    if (!visited[can])
                    {
                    String [] newstr = new String[2];
                    newstr[0] = words[can];
                    newstr[1] = String.valueOf(Integer.parseInt(now[1])+1);
                    q.add(newstr);
                    visited[can] = true;
                        
                    }
                }
            }
            
        }
        
        return 0;

    }
    
    public List<Integer> canchange (String origin, String [] words)
    {
        //가능한 모든 변환 list
        List<Integer> canlist = new ArrayList<>();
        
        for (int i = 0 ; i<words.length; i++)
        {
            String comp = words[i];
            int check = 0;
            for (int j = 0 ; j<comp.length(); j++)
            {
                if (comp.charAt(j) != origin.charAt(j))
                {
                    check+=1;
                }
            }
            if(check == 1)
            {
                canlist.add(i);
            }
        }
        return canlist;
    }
}