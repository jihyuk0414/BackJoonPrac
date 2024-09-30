import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputarr = br.readLine().split(" ");
        int N = Integer.parseInt(inputarr[0]);
        int M = Integer.parseInt(inputarr[1]);

        String[] inputarr2 = br.readLine().split(" ");
        long[] narr = new long[N];

        for (int i = 0; i < N; i++) {
            narr[i] = Long.parseLong(inputarr2[i]);
        }

        long answer = 0;
        for (int i = 0; i < M; i++) {
            answer += narr[i];
        }

        long cnt = answer;
        for (int i = M; i < N; i++) {
            cnt += narr[i] - narr[i - M];
            answer = Math.max(answer, cnt);
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}