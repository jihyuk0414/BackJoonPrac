import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String oneline = br.readLine();

        int totalR = 0;
        int totalB = 0;

        for (int i = 0; i < N; i++) {
            if (oneline.charAt(i) == 'R') totalR++;
            else totalB++;
        }

        int leftR = 0;
        for (int i = 0; i < N; i++) {
            if (oneline.charAt(i) == 'R') leftR++;
            else break;
        }

        int rightR = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (oneline.charAt(i) == 'R') rightR++;
            else break;
        }

        int leftB = 0;
        for (int i = 0; i < N; i++) {
            if (oneline.charAt(i) == 'B') leftB++;
            else break;
        }

        int rightB = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (oneline.charAt(i) == 'B') rightB++;
            else break;
        }

        int answer = Math.min(totalR - leftR, totalR - rightR);
        answer = Math.min(answer, totalB - leftB);
        answer = Math.min(answer, totalB - rightB);

        bw.write(String.valueOf(answer));
        bw.close();
    }
}
