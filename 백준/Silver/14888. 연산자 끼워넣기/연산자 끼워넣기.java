import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N; 
    static int[] Narr;
    static int[] matharr; 
    static int maxanswer = Integer.MIN_VALUE; 
    static int minanswer = Integer.MAX_VALUE; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String[] inputstr = br.readLine().split(" ");
        Narr = new int[N];
        for (int i = 0; i < N; i++) {
            Narr[i] = Integer.parseInt(inputstr[i]);
        }
        
        String[] inputstr2 = br.readLine().split(" ");
        matharr = new int[4]; 
        for (int i = 0; i < 4; i++) {
            matharr[i] = Integer.parseInt(inputstr2[i]);
        }

        backtracking(0, Narr[0], 0);
        bw.write(String.valueOf(maxanswer));
        bw.write("\n");
        bw.write(String.valueOf(minanswer));
        bw.close();
    }

    public static void backtracking(int depth, int sumnum, int nextindex) {
        if (depth == N - 1) {
            maxanswer = Math.max(maxanswer, sumnum);
            minanswer = Math.min(minanswer, sumnum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (matharr[i] > 0) {
                matharr[i]--;
                int nextNum = Narr[nextindex + 1];

                if (i == 0) {
                    backtracking(depth + 1, sumnum + nextNum, nextindex + 1);
                } else if (i == 1) {
                    backtracking(depth + 1, sumnum - nextNum, nextindex + 1);
                } else if (i == 2) {
                    backtracking(depth + 1, sumnum * nextNum, nextindex + 1);
                } else if (i == 3) {
                    if (nextNum != 0) { // 0으로 나누는 경우를 방지
                        backtracking(depth + 1, sumnum / nextNum, nextindex + 1);
                    }
                }

                matharr[i]++;
            }
        }
    }
}