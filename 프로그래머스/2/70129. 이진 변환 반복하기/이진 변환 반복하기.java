class Solution {
    public int[] solution(String s) {
        int[] answer = new int [2];
        int zerocnt = 0 ;
        int howmanychange= 0 ;
        
        while (true)
        {
            String news = s.replace("0","");
            zerocnt += (s.length()-news.length());
            
            s = news;
            
            howmanychange +=1;
            
            if (s.length() ==1 )
            {
                break;
            } 
            
            //s의 길이를 2진법으로
            StringBuilder sb = new StringBuilder();
            
            int fornews = s.length();
            
            int twozin = 0 ;
            while (fornews > 0)
            {
                int left = fornews%2;
                sb.append(String.valueOf(left));
                fornews = fornews/2;
            }
            
            s= sb.reverse().toString();
            
            
        }
        
        answer[0] = howmanychange;
        answer[1] = zerocnt;
        
        return answer;
    }
}