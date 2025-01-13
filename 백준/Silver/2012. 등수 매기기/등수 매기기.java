import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] Narr = new int[N];
        
        for (int i = 0; i < N; i++) {
            Narr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(Narr);
        
        long answer = 0; // int에서 long으로 변경
        for (int i = 0; i < N; i++) {
            answer += Math.abs(Narr[i] - (i + 1));
        }
        
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}