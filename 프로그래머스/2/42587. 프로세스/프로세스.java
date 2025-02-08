import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> nowq= new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
        Collections.reverseOrder());
        
        for (int i = 0 ; i<priorities.length; i++)
        {
            int [] newarr = new int[]{i,priorities[i]};
            nowq.add(newarr);
            pq.add(priorities[i]); //pq는 우선순위만
        }
        
        while (!nowq.isEmpty())
        {
            int [] now = nowq.peek();
            int nowval = now[1];//우선순위
            
            if (now[1]==pq.peek())
            {
                //나갈 차례가 맞다면
                
                answer +=1;
                if (now[0] == location)
                {
                    return answer;
                }
                //나가긴하는데 답이 아니라면
                pq.poll();
                nowq.poll();
                continue;
            } else {
                nowq.add(nowq.poll());
            }
            
            
        }
        
        return answer;
    }
}