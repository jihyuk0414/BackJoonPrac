import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0 ; i<works.length; i++)
        {
            pq.add(works[i]);
        }
        
        int k = 0;
        
        while (k<n)
        {
            int now = pq.poll();
            if (now == 0)
            {
                break;
            }
            now -=1;
            k+=1;
            pq.add(now);
        }
        
        while (!pq.isEmpty())
        {
            int val = pq.poll();
            answer += (val*val);
        }
        
        return answer;
    }
}