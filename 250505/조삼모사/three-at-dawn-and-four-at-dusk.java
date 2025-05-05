import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] Narr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Narr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] oneline = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                Narr[i][j] = Integer.parseInt(oneline[j]);
            }
        }

        DFS(new ArrayList<Integer>(), 0);

        bw.write(answer + "");
        bw.close();
    }

    public static int calculate(List<Integer> list) {
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    int a = list.get(i);
                    int b = list.get(j);
                    cnt += Narr[a][b];
                }
            }
        }
        return cnt;
    }

    public static void DFS(List<Integer> list, int start) {
        if (list.size() == N / 2) {
            List<Integer> nochoselist = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!list.contains(i)) {
                    nochoselist.add(i);
                }
            }

            answer = Math.min(Math.abs(calculate(list) - calculate(nochoselist)), answer);
            return;
        }

        for (int i = start; i < N; i++) {
            list.add(i);
            DFS(list, i + 1); 
            list.remove(list.size() - 1); 
        }
    }
}
