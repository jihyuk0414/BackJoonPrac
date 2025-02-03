import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int N = people.length;
        
        Integer [] sortpeople = new Integer[N];
        for (int i = 0 ; i<people.length; i++)
        {
            sortpeople[i] = people[i];
        }
        
        int start = 0 ;
        int end = N-1;
        
        //1부터~n까지임 주의
        boolean [] ok = new boolean[N];
        Arrays.sort(sortpeople, Collections.reverseOrder());
        
        while (start <=end)
        {
            int val = sortpeople[start]+sortpeople[end];
            
            if (ok[start] || ok[end])
            {
                start +=1; 
                continue;
            }
            
            if (val > limit)
            {
                start +=1;
            } else if (val <= limit) {
                ok[start] = true;
                ok [end] = true;
                answer+=1;
                end -=1;
            } 
        }
        
        for (int i = 0 ; i<ok.length ; i++)
        {
            if (!ok[i])
            {
                answer +=1;
            }
        }
        return answer;
    }
}