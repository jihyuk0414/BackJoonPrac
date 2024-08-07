class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String [] myanswer = polynomial.split(" ");
        int xcnt = 0 ; 
        int cnt = 0 ;
        for (int i =0 ; i<myanswer.length ; i ++)
        {
            String now = myanswer[i];
            
            if(now.contains("x")){
                if (now.length() == 1)
                {
                    xcnt += 1 ;
                }
                else
                {
                    xcnt += Integer.parseInt(now.replace("x",""));
                }
            }
            else if(now.equals("+"))
            {
                continue;
            }
            else {
                cnt += Integer.parseInt(now);
            }
            
        }

        if (xcnt == 0 )
        {
            if (cnt == 0 )
            {
                answer = "0"; 
            }
            else
            {
                answer = ""+cnt ; 
            }
        }
        else
        {
            if (cnt ==0 )
            {
                if (xcnt == 1)
                {
                    answer = "x";
                }
                else
                {
                    answer = (xcnt + "x");
                }
                
            }
            else
            {
                if (xcnt == 1)
                {
                    answer = ("x" + " +" + " " + cnt );
                }
                else
                {
                    answer = (xcnt + "x" + " +" + " " + cnt );
                }
                
            }
        }
        return answer;
    }
}