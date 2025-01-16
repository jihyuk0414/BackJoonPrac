import java.util.*;
import java.io.*;

class Main {

    static int N, M;
    static int[] narr;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstline = br.readLine().split(" ");
        N = Integer.parseInt(firstline[0]);
        M = Integer.parseInt(firstline[1]);

        narr = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            narr[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            String[] oneline = br.readLine().split(" ");
            int whattodo = Integer.parseInt(oneline[0]);
            int a = Integer.parseInt(oneline[1]);
            int b = Integer.parseInt(oneline[2]);

            if (whattodo == 0) {
                union(a, b);
            } else {
                if (isSameTree(a, b)) {
                    bw.write("YES");
                } else {
                    bw.write("NO");
                }
            }
            if (i != M - 1) {
                bw.write("\n");
            }
        }

        bw.close();
    }

    public static int find(int x) {
        if (narr[x] != x) {
            narr[x] = find(narr[x]);
        }
        return narr[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] > rank[rootY]) {
            narr[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            narr[rootX] = rootY;
        } else {
            narr[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static boolean isSameTree(int x, int y) {
        return find(x) == find(y);
    }
}
