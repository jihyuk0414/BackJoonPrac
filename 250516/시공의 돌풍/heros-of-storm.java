import java.util.*;
import java.io.*;

public class Main {

    static int n, m, t;
    static int[][] map;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    // 각 변수를 개별적으로 초기화
    static int tor1x = -1, tor1y = -1, tor2x = -1, tor2y = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        String[] oneline = br.readLine().split(" ");
        n = Integer.parseInt(oneline[0]);
        m = Integer.parseInt(oneline[1]);
        t = Integer.parseInt(oneline[2]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] twonline = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(twonline[j]);
            }
        }

        // 공기청정기 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    if (tor1x == -1) {
                        tor1x = i;
                        tor1y = j;
                    } else {
                        tor2x = i;
                        tor2y = j;
                        break;
                    }
                }
            }
        }

        // t초 동안 반복
        for (int time = 0; time < t; time++) {
            // 확산 - 먼지 이동량 계산
            int[][] graph = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 먼지가 있는 칸에서만 확산 계산
                    if (map[i][j] > 0) {
                        int nowval = map[i][j];
                        int spreadAmount = nowval / 5;
                        int howmanygo = 0;
                        
                        for (int z = 0; z < 4; z++) {
                            int nx = i + dx[z];
                            int ny = j + dy[z];

                            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                                // 공기청정기가 아닌 칸으로만 확산
                                if (map[nx][ny] != -1) {
                                    howmanygo++;
                                    graph[nx][ny] += spreadAmount;
                                }
                            }
                        }
                        // 확산으로 감소하는 양 계산
                        graph[i][j] -= (spreadAmount * howmanygo);
                    }
                }
            }

            // 확산 결과 적용
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] += graph[i][j];
                }
            }

            // 공기청정기 작동
            moveclock(tor1x, tor1y);
            movereverseclock(tor2x, tor2y);
        }

        // 남아있는 미세먼지 양 계산
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    answer += map[i][j];
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }

    // 위쪽 공기청정기 - 시계 방향 순환
    public static void moveclock(int x, int y) {
        // 위로 이동
        for (int i = x - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        
        // 왼쪽으로 이동
        for (int j = 0; j < m - 1; j++) {
            map[0][j] = map[0][j + 1];
        }
        
        // 아래로 이동
        for (int i = 0; i < x; i++) {
            map[i][m - 1] = map[i + 1][m - 1];
        }
        
        // 오른쪽으로 이동
        for (int j = m - 1; j > 1; j--) {
            map[x][j] = map[x][j - 1];
        }
        
        // 공기청정기에서 나오는 바람은 깨끗한 공기
        map[x][1] = 0;
    }

    // 아래쪽 공기청정기 - 반시계 방향 순환
    public static void movereverseclock(int x, int y) {
        // 아래로 이동
        for (int i = x + 1; i < n - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        
        // 왼쪽으로 이동
        for (int j = 0; j < m - 1; j++) {
            map[n - 1][j] = map[n - 1][j + 1];
        }
        
        // 위로 이동
        for (int i = n - 1; i > x; i--) {
            map[i][m - 1] = map[i - 1][m - 1];
        }
        
        // 오른쪽으로 이동
        for (int j = m - 1; j > 1; j--) {
            map[x][j] = map[x][j - 1];
        }
        
        // 공기청정기에서 나오는 바람은 깨끗한 공기
        map[x][1] = 0;
    }
}