import java.util.*;
import java.io.*;
class Main {
    static final int MOD = 900528;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oneline = br.readLine();
        String target = br.readLine();
        
        Map<Character, Integer> nmap = new HashMap<>();
        for (int i = 0; i < oneline.length(); i++) {
            nmap.put(oneline.charAt(i), i);
        }
        
        int M = oneline.length();
        int N = target.length();
        long answer = 0;
        
        // 이전 자릿수들의 합 계산
        long temp = 1;
        for (int i = 1; i < N; i++) {
            temp = (temp * M) % MOD;
            answer = (answer + temp) % MOD;
        }
        
        // 현재 문자열의 위치 계산
        temp = 1;
        for (int i = N-1; i >= 0; i--) {
            int idx = nmap.get(target.charAt(i));
            answer = (answer + (idx * temp) % MOD) % MOD;
            if (i > 0) temp = (temp * M) % MOD;
        }
        
        System.out.println((answer + 1) % MOD);
    }
}