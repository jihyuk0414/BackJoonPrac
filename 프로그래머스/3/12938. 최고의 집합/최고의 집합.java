class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n] ;
        if (s < n) {
            return new int[] {-1};
        }
        
        int basic = s/n;
        int remain = s%n;
        
        for (int i = 0 ; i<n ; i++)
        {
            answer[i] = basic;
        }
        
        for (int i = n-1; i>=n-remain; i--)
        {
            answer[i] +=1;
        }
        
        return answer;
    }
}