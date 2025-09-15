import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static int maxCnt = 0;
    static int answer = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] > 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int startX, int startY) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0}); // x, y, cnt
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            boolean hasNext = false;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && graph[nx][ny] > 0) {
                        hasNext = true;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }

            if (!hasNext) {
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    answer = graph[startX][startY] + graph[x][y];
                } else if (cnt == maxCnt) {
                    answer = Math.max(answer, graph[startX][startY] + graph[x][y]);
                }
            }
        }
    }
}
