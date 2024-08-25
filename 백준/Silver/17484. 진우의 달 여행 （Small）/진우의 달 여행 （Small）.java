import java.io.*;

class Main {

    static int N, M;
    static int[][] Nlist;
    static int[] dx = {1, 1, 1};
    static int[] dy = {-1, 0, 1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputarr = br.readLine().split(" ");
        N = Integer.parseInt(inputarr[0]);
        M = Integer.parseInt(inputarr[1]);

        Nlist = new int[N][M];
        for (int i = 0; i < N; i++) { // 수정: i < N으로 변경
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                Nlist[i][j] = Integer.parseInt(row[j]);
            }
        }

        // Start DFS for each column in the first row
        for (int i = 0; i < M; i++) {
            DFS(0, i, -1, 1, Nlist[0][i]);
        }

        // Output the result
        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static void DFS(int x, int y, int before, int depth, int totalcost) {
        if (depth == N) {
            answer = Math.min(answer, totalcost);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (i != before) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    DFS(nx, ny, i, depth + 1, totalcost + Nlist[nx][ny]);
                }
            }
        }
    }
}
