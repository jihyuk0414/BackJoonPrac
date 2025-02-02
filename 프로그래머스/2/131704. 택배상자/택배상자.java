import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int N = order.length; 
        
        Queue<Integer> rail = new LinkedList<>();
        Stack<Integer> bozo = new Stack<>();
        
        for (int i =1 ; i<=N;  i++)
        {
            rail.add(i);
        }
        
        for (int i = 0 ; i<order.length; i++)
        {
            int now =order[i];
            
            if (!bozo.isEmpty())
            {
                if (bozo.peek() == now)
                {
                    bozo.pop();
                    answer+=1;
                    continue;
                }
            }
            
            while (!rail.isEmpty() && rail.peek() != now )
            {
                //레일엔 뭐가 있고 지금 당장 기사줄수 없을 때 
                bozo.push(rail.poll());
            }
            
            if (!rail.isEmpty())
            {
                if (rail.peek() == now)
                {
                    rail.poll();
                    answer+=1;
                    continue;
                }
            } 
            
            if (rail.isEmpty())
            {
                break;
            }
        }
        
        return answer;
    }
}