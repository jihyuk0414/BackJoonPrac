import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int [] [] int_book_time = new int [book_time.length][2];
        for (int i = 0 ; i<book_time.length ; i++)
        {
            String [] start = book_time[i][0].split(":");
            int startint = Integer.parseInt(start[0])*100 + Integer.parseInt(start[1]);
            String [] end = book_time[i][1].split(":");
            int endint = Integer.parseInt(end[0])*100 + Integer.parseInt(end[1]);
            int_book_time[i] = new int [] {startint,endint};
        }
        
        
        Arrays.sort(int_book_time, (a,b) ->
                    {
                        return a[0] - b[0];
                    });
        
        PriorityQueue<Integer> q = new PriorityQueue<>(); // 종료
        
        for (int i = 0 ; i<int_book_time.length; i++)
        {
            int start = int_book_time[i][0];
            int end = int_book_time[i][1];
  
            if (q.isEmpty())
            {
                q.add(end);
                answer= Math.max(answer,q.size());
            } else {
                while (!q.isEmpty())  
                {
                    int endorigin = q.peek()+10;
                    if (endorigin % 100 >= 60)
                    {
                        endorigin += 100;
                        endorigin -= 60;
                    }
                    
                    if(endorigin<= start)
                    {
                        q.poll();
                    }else {
                        break;
                    }
                    
                }
                q.add(end);
                answer = Math.max(answer, q.size());
            }
            
        }
        
        
        
        return answer;
    }
}