class Solution {
    public String solution(String my_string, String overwrite_string, int s) {

        String answer = "" ;
        //자바 문자열이 불변이구나. 
        String left = my_string.substring(0,s);
        String right = overwrite_string.substring(0,overwrite_string.length()) ; 
        
        if (s+overwrite_string.length() < my_string.length())
        {
            String plus = my_string.substring(overwrite_string.length()+s,my_string.length());
            answer += left ;
            answer += right;
            answer += plus;
            
        }
        else
        {
            answer += left ;
            answer += right;
        }
        
        
        return answer ;
    
    }
}