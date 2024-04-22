import java.util.Arrays; 
import java.util.Collections;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String nstr = Long.toString(n);
        int nlen= nstr.length();
        
        long[] longarr = new long[nlen];
        
        for (int i =0; i<nlen; i++)
        {
            longarr[i] = Long.parseLong(String.valueOf(nstr.charAt(i))) ;
        }
        Arrays.sort(longarr) ;
       
        int cnt = 1;
        for (int i = 0; i<nlen ; i++)
        {
            answer = answer + longarr[i]*cnt ;
            cnt = cnt*10 ; 
        }
        
        return answer;
    }
}