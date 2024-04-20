class Solution {
    public long solution(long n) {
        
        if (n==1)
        {
            return 4;
        }
        long answer = 0;
        
        for (long i= 0; i<n; i++)
        {
            if (i*i == n)
            {
                return (i+1)*(i+1) ;
            }
        }
        return -1;

    }
}