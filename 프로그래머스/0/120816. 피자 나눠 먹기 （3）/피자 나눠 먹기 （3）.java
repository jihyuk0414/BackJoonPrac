class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        int cnt = 0 ;
        for (int i = 1 ; i<10000 ; i++)
        {
            cnt = slice*i ; 
            if (cnt>= n)
            {
                answer = i;
                break ; 
            }
        }
        return answer;
    }
}