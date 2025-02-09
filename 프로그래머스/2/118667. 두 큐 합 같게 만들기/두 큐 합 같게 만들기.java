import java.util.*;

class Solution {
    
    public long totalsum,smallsum,bigsum;
    
    public int solution(int[] queue1, int[] queue2) {
        int answer =0 ;
        int n1 = queue1.length;
        int n2 = queue2.length;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        long q1sum = 0;
        long q2sum = 0 ;
        
        for (int i = 0 ; i<queue1.length; i ++)
        {
            q1.add((long)queue1[i]);
            q1sum+=queue1[i];
        }
        
        for (int i = 0 ; i<queue2.length; i ++)
        {
            q2.add((long)queue2[i]);
            q2sum+=queue2[i];
        }
        
        totalsum = q1sum+q2sum; //두개 sum 확인
        
        Queue<Long> minq = q1sum>=q2sum ? q2: q1;
        Queue<Long> bigq = q1sum>=q2sum ? q1: q2;
        bigsum = q2sum>=q1sum ? q2sum: q1sum;
        smallsum = q2sum>=q1sum ? q1sum: q2sum;
        
        while (answer <= (n1+n2)*2)
        {
            //같으면 끝
            if (bigsum == totalsum/2 && smallsum == totalsum/2)
            {
                return answer ;
            }
            answer +=1;
            
            long val =bigq.poll() ;
            minq.add(val); //빼서 더하고
            bigsum -= val;
            smallsum += val;
            
            //smallsum이 역전했을 수 있고 
            if (smallsum >= bigsum)
            {
                long temp = bigsum;
                bigsum = smallsum;
                smallsum = temp;
                
                Queue<Long>tempq = bigq;
                bigq = minq;
                minq = tempq;
            }
        }

        
        return -1;
    }
}