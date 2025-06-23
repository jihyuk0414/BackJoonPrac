import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int []> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i<priorities.length; i++)
        {
            q.add(new int [] {priorities[i],i}); // 값, idx
            pq.add(priorities[i]);
        }
        
        int cnt = 1;
        int targetval = priorities[location];
        while(!q.isEmpty())
        {
            int [] now = q.poll();

            
            int maxval = pq.peek();
            if (now[0] == maxval)
            {            
                if (now[0] == targetval && now[1] == location)
                {
                    //값도, idx도 맞다면 
                    return cnt;
                }
                pq.poll();
                cnt +=1;
            }
            else
            {
                q.add(now);
            }
            
        }
        
        return answer;
    }
}