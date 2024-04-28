
class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] letterarr = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-","...-",
                ".--","-..-","-.--","--.."};
        
        for (int i =0 ; i<letterarr.length; i++)
        {
            for (int j =0 ; j<morse.length; j++)
            {
                if (letterarr[i].equals(morse[j]))
                {
                    
                   char moschange= (char) (j+'a');
                   answer += String.valueOf(moschange); 
                   break;    
                }
                
                
            }
        
        }
        return answer;
    }
}