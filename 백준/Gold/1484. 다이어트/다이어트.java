import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int G = Integer.parseInt(br.readLine());
        List<Integer> answerlist = new ArrayList<>();
        
        for (int i = 1; i < 100000; i++) {
            long y = (long)i * i;
            long xpow = G + y;
            
            // 제곱근을 구하고 정수로 변환
            long sqrtX = (long)Math.sqrt(xpow);
            
            // sqrtX가 실제로 xpow의 제곱근인지 확인
            if (sqrtX * sqrtX == xpow && sqrtX > i) {
                answerlist.add((int)sqrtX);
            }
        }
        
        Collections.sort(answerlist);
        
        if (answerlist.isEmpty()) {
            bw.write("-1");
        } else {
            for (Integer val : answerlist) {
                bw.write(String.valueOf(val) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}