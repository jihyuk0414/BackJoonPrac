class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String strc = String.valueOf(a)+String.valueOf(b);
        String strd = String.valueOf(b)+String.valueOf(a);
        int c = Integer.parseInt(strc) ;
        int d = Integer.parseInt(strd) ;
        answer = Math.max(c,d);
        
        return answer;
    }
}