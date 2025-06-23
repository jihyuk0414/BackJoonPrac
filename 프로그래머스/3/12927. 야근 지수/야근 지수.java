import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0 ; i<works.length; i++)
        {
            q.add(works[i]);
        }
        
        int cnt = 0 ;
        
        while(cnt < n && !q.isEmpty())
        {
            int now = q.poll();
            if ((now -1) <= 0)
            {
                cnt +=1;
                continue;
            }
            else
            {
                q.add(now -1);
                cnt +=1;
                continue;
            }
        }
        
        for (Integer val : q)
        {
            answer += (val*val);
        }
        
        return answer;
    }
}