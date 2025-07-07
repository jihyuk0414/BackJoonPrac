import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<int []> pq = new PriorityQueue<>(
        (a,b) -> 
            {
                return a[0]-b[0];
            });
        
        for (int i = 0 ; i<book_time.length; i++)
        {
            String now = book_time[i][0];
            String [] firstarr = now.split(":");
            int totaltime1 = 0;
            totaltime1+= Integer.parseInt(firstarr[0])*60;
            totaltime1+= Integer.parseInt(firstarr[1]);
            
            String [] secondarr = book_time[i][1].split(":");
            int totaltime2 = 0;
            totaltime2+= Integer.parseInt(secondarr[0])*60;
            totaltime2+= Integer.parseInt(secondarr[1]);
            
            pq.add(new int [] {totaltime1,totaltime2});
        }
        
        PriorityQueue<int []> pq2 = new PriorityQueue<>(
        (a,b) -> 
            {
                return a[1]-b[1];
            });
        
        
        while(!pq.isEmpty())
        {
            int [] now = pq.poll();
            
            while(!pq2.isEmpty() && pq2.peek()[1] <= now[0] )
            {
                pq2.poll();
            }
            
            int [] newarr = new int [] {now[0],now[1]+10};
            
            pq2.add(newarr);
            answer = Math.max(pq2.size(),answer);
            
        }
        
        return answer;
    }
}