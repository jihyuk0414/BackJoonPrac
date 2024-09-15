import java.util.* ; 

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> myq = new PriorityQueue<>();
        
        for(int next : scoville)
        {
            myq.add(next);
        }
        if (myq.peek() >= K)
        {
            return 0;
        }
        
        while (myq.size() >= 1)
        {
            answer +=1 ;
            if (myq.size() ==1)
            {
                if(myq.peek() < K)
                {
                    return -1;
                } else{
                    return answer;
                }
            }
            
            int first = myq.poll();
            int second = myq.poll();
            
            myq.add(first+second*2);
            
            if(myq.peek() >=K) 
            {
                return answer;
            } 

            
        }
        
        
        
        return answer;
    }
}