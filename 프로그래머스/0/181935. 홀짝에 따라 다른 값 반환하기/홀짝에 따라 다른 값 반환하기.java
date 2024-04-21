class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n%2 != 0 )
        {
            //홀수라면
            int cnt = 0 ;
            for (int i = 1; i<=n; i++)
            {
                if(i%2 != 0)
                {
                    cnt += i ;

                }
            }
            return cnt ;
        }
        
        else
        {
            int cnt = 0 ;
            for (int i = 1; i<=n; i++)
            {
                if(i%2 == 0)
                {
                    cnt += (i*i) ;
                }
            }
            return cnt ;
        }
        
    }
}