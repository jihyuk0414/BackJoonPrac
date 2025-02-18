class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        int maxtime = 0;
        for (int time : times)
        {
            maxtime = Math.max(maxtime,time);
        }
        
        long start = 0 ;
        long end = (long) maxtime* n;
        
        while (start<=end)
        {
            long mid = start + (end-start)/2;
            
            long person = 0 ;
            
            for (int time:times)
            {
                person += (mid/time);
            }
            
            if (person >= n)
            {
                answer = Math.min(answer,mid);
                end = mid-1;
            } else if (person < n)
            {
                start = mid+1;
            } 
            
        }
        return answer;
    }
}