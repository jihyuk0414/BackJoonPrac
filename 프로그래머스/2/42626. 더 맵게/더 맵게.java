import java.util.*; 

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int n = scoville.length;
        int cnt = 0 ;
        
        for (int i = 0 ; i<n ; i++)
        {
            pq.add(scoville[i]);
        }
        
        while(pq.size() > 1)
        {
            if (pq.peek() >= K)
            {
                break;
            }
            
            //더 요리해야되면
            cnt +=1;
            int one = pq.poll();
            int two = pq.poll();
            
            pq.add(one+two*2);
        }
        
        if (pq.peek() < K)
        {
            cnt = -1;
        }
        
        return cnt ;
    }
}