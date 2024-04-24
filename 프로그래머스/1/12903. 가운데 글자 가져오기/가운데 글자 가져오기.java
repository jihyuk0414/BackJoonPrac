class Solution {
    public String solution(String s) {
        String answer = "";
        int slen = s.length();
        if(slen%2 == 0)
        {
            answer += s.charAt(slen/2 -1) ;
            answer += s.charAt(slen/2) ;
        }
        else
        {
            answer += s.charAt(slen/2) ;
        }
        return answer;
    }
}