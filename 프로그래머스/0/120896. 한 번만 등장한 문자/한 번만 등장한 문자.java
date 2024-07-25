import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String [] cntarr = s.split("");
        
        Arrays.sort(cntarr);
        
        for (int i = 0; i<cntarr.length; i ++)
        {
            int cnt = 0;
            for (int j =0 ; j<cntarr.length; j++)
            {
                    if(cntarr[i].equals(cntarr[j]))
                    {
                        cnt+=1;
                    }

            }

            if (cnt == 1)
            {
                answer+=cntarr[i];
            }
        }
        return answer;
    }
}