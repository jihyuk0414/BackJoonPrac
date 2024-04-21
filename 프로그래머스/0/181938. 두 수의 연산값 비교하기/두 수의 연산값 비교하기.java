class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String strc = String.valueOf(a)+String.valueOf(b) ;
        int c = Integer.parseInt(strc) ;
        int d = 2*a*b;
        
        answer = Math.max(c,d);
        
        return answer;
    }
}