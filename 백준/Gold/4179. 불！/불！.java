import java.util.*;
import java.io.*;

class Main {
    public static char[][] originmap;
    public static int R, C;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int[][] fireTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstline = br.readLine().split(" ");
        R = Integer.parseInt(firstline[0]);
        C = Integer.parseInt(firstline[1]);

        originmap = new char[R][C];
        fireTime = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(fireTime[i], Integer.MAX_VALUE);
        }

        int startx = 0, starty = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                originmap[i][j] = line.charAt(j);
                if (originmap[i][j] == 'J') {
                    startx = i;
                    starty = j;
                }
            }
        }

        fireBFS();

        int ans = personBFS(startx, starty);
        if (ans == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(ans);
    }

    public static void fireBFS() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (originmap[i][j] == 'F') {
                    fireTime[i][j] = 0;
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], t = cur[2];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (originmap[nx][ny] != '#' && fireTime[nx][ny] > t + 1) {
                        fireTime[nx][ny] = t + 1;
                        q.add(new int[]{nx, ny, t + 1});
                    }
                }
            }
        }
    }

    public static int personBFS(int startx, int starty) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        q.add(new int[]{startx, starty, 0});
        visited[startx][starty] = true;
        if (startx == 0 || startx == R - 1 || starty == 0 || starty == C - 1) return 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], t = cur[2];
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (originmap[nx][ny] == '.' && !visited[nx][ny]) {
                        if (t + 1 < fireTime[nx][ny]) {
                            if (nx == 0 || nx == R - 1 || ny == 0 || ny == C - 1) return t + 2;
                            visited[nx][ny] = true;
                            q.add(new int[]{nx, ny, t + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
