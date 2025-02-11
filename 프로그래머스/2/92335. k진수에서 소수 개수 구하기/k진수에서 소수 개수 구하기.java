import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(String.valueOf(n % k));
            n /= k;
        }
        String strn = sb.reverse().toString();
        long newn = Long.parseLong(strn);
       
        System.out.println(strn);
        
        StringBuilder newsb = new StringBuilder();
        
        // 문자열을 파싱할 때 long을 사용
        for (int i = 0; i <= strn.length(); i++) {
            if (i == strn.length() || strn.charAt(i) == '0' ) {
                if (newsb.length() == 0) {
                    continue;
                }

                if (Long.parseLong(newsb.toString()) != 1) {
                    if (isitsosu(Long.parseLong(newsb.toString()))) {
                        answer += 1;
                    }
                }
                
                newsb.setLength(0); 
            } else {
                newsb.append(strn.charAt(i));
            }
        }
        
        return answer;
    }

    public boolean isitsosu(long val) {
        if (val < 2) return false;  // 1과 0은 소수가 아님
        for (long i = 2; i <= Math.sqrt(val); i++) {  // long을 사용하여 루프 변경
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }

}
