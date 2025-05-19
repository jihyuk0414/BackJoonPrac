import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, 1, 1, 0, -1, -1, -1, 0, 1}; // 처음껀 0
    public static List<int[]> growup = new ArrayList<>();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        M = Integer.parseInt(oneline[1]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] twoline = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(twoline[j]);
            }
        }

        growup.add(new int[]{N-2, 0});
        growup.add(new int[]{N-2, 1});  
        growup.add(new int[]{N-1, 0});
        growup.add(new int[]{N-1, 1});

        int[][] moves = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] move = br.readLine().split(" ");
            moves[i][0] = Integer.parseInt(move[0]);
            moves[i][1] = Integer.parseInt(move[1]);
        }

        for (int day = 0; day < M; day++) {
            int d = moves[day][0];
            int p = moves[day][1];
            
            Set<String> fertilizerPositions = new HashSet<>();

            for (int[] grow : growup) {
                int x = grow[0];
                int y = grow[1];

                grow[0] = ((x + dx[d] * p) % N + N) % N;
                grow[1] = ((y + dy[d] * p) % N + N) % N;
                
                map[grow[0]][grow[1]] += 1;
            }

            for (int[] grow : growup) {
                fertilizerPositions.add(grow[0] + "," + grow[1]);
            }

            for (int[] grow : growup) {
                int x = grow[0];
                int y = grow[1];
                int count = 0;

                for (int i = 2; i <= 8; i += 2) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (map[nx][ny] >= 1) {
                            count++;
                        }
                    }
                }
                map[x][y] += count;
            }

            List<int[]> newGrowup = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] >= 2) {
                        String position = i + "," + j;
                        if (!fertilizerPositions.contains(position)) {
                            newGrowup.add(new int[]{i, j});
                            map[i][j] -= 2;
                        }
                    }
                }
            }
            growup = newGrowup;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += map[i][j];
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}