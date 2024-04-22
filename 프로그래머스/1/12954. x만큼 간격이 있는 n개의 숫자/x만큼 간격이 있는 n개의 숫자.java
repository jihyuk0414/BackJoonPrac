class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long longx= (long)x;
        
        for (int i = 0; i<n; i++)
        {
            answer[i] = longx;
            longx+=(long)x;
        }
        return answer;
    }
}