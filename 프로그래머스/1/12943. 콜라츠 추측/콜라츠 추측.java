class Solution {
    public int solution(int num) {
        int answer = 0;
        int cnt = 0 ;
        
        long n = (long) num;
        
        while (n!= 1)
        {
            if (cnt>=500)
            {
                cnt = -1;
                break;
            }
            if (n%2 ==0)
            {
                n /= 2;
                cnt +=1 ;
            }
            else
            {
                n = n*3 +1;
                cnt+=1;
            }
        }
        answer = cnt;
        
        return answer;
    }
}