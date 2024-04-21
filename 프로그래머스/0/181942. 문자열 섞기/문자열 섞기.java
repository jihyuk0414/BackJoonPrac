class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int cnt = 0 ;
        int a = str1.length();
        while(cnt < a )
        {
           
            answer += str1.charAt(cnt) ;
            
            answer += str2.charAt(cnt) ;

            cnt +=1;
        }
        return answer;
    }
}