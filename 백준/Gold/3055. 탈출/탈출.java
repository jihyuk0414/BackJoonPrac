import java.util.*;
import java.io.*;

class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int R, C;
    static char[][] nmap;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] oneline = br.readLine().split(" ");
        R = Integer.parseInt(oneline[0]);
        C = Integer.parseInt(oneline[1]);

        nmap = new char[R][C];
        Queue<int[]> waterQueue = new LinkedList<>();
        Queue<int[]> sQueue = new LinkedList<>();

        int sx = -1, sy = -1;
        
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                nmap[i][j] = row.charAt(j);
                if (nmap[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (nmap[i][j] == '*') {
                    waterQueue.add(new int[] {i, j});
                }
            }
        }

        sQueue.add(new int[] {sx, sy, 0});
        boolean[][] visited = new boolean[R][C];
        visited[sx][sy] = true;

        while (!sQueue.isEmpty()) {
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                int[] water = waterQueue.poll();
                int x = water[0], y = water[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (0 <= nx && nx < R && 0 <= ny && ny < C && nmap[nx][ny] == '.') {
                        nmap[nx][ny] = '*';
                        waterQueue.add(new int[] {nx, ny});
                    }
                }
            }

            int sSize = sQueue.size();
            for (int i = 0; i < sSize; i++) {
                int[] s = sQueue.poll();
                int x = s[0], y = s[1], depth = s[2];
                
                if (nmap[x][y] == 'D') {
                    bw.write(depth + "\n");
                    bw.close();
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (0 <= nx && nx < R && 0 <= ny && ny < C && !visited[nx][ny] && nmap[nx][ny] != '*' && nmap[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        sQueue.add(new int[] {nx, ny, depth + 1});
                    }
                }
            }
        }

        bw.write("KAKTUS\n");
        bw.close();
    }
}
