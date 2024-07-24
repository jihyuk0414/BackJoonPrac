class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i =0; i<my_string.length(); i++)
        {
            String myval = String.valueOf(my_string.charAt(i));
            
            if (myval.toUpperCase().equals(myval))
            {
                //이미 대문자;
                answer += myval.toLowerCase();
            }
            else{
                answer += myval.toUpperCase();
            }
        }
        return answer;
    }
}