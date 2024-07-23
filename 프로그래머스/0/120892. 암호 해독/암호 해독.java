class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        cipher = "0"+cipher ;
        for (int i = 1; i<cipher.length() ; i++)
        {
            if (i%code == 0 )
            {
                answer += cipher.charAt(i) ;
            }
            
        }
        return answer;
    }
}