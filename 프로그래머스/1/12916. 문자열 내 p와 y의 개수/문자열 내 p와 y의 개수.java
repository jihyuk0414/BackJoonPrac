class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String news = s.toUpperCase() ;
        int pcnt = 0;
        int ycnt= 0;
        for (int i = 0 ; i<news.length(); i++)
        {
            if (news.charAt(i) == 'P') {
                pcnt+=1 ;
            }
            else if (news.charAt(i) == 'Y' ){
                ycnt+=1;
            }
        }
        
        if (pcnt == ycnt)
        {
            answer = true ; 
        }
        else
        {
            answer = false;
        }
        
        return answer;
    }
}