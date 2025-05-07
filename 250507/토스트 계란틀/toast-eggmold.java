import java.util.*;
import java.io.*;

public class Main {

    static int N, L, R;
    static int[][] graph;
    static boolean[][] checked; // 각 이동 주기마다 연합에 포함된 국가 체크
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]); // 지역 변수 N 대신 클래스 변수 N 사용
        L = Integer.parseInt(oneline[1]);
        R = Integer.parseInt(oneline[2]);

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] twoline = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(twoline[j]);
            }
        }

        while (true) {
            checked = new boolean[N][N]; // 매 이동 주기마다 초기화
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!checked[i][j]) { // 아직 연합에 포함되지 않은 국가만 처리
                        if (findvisited(i, j)) {
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) {
                bw.write(answer + "");
                bw.flush();
                bw.close();
                break; // 루프 종료
            }
            
            answer++; // 인구 이동 횟수 증가
        }
    }

    public static boolean findvisited(int startx, int starty) {
        Queue<int[]> q = new LinkedList<>();
        
        checked[startx][starty] = true; // 현재 국가를 연합에 포함
        
        int save = graph[startx][starty];
        
        List<int[]> idxlist = new ArrayList<>();
        idxlist.add(new int[]{startx, starty});
        
        q.add(new int[]{startx, starty});
        
        while (!q.isEmpty()) {
            int[] nowarr = q.poll();
            int nowx = nowarr[0];
            int nowy = nowarr[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = nowx + dx[i];
                int ny = nowy + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < N && !checked[nx][ny]) { // 아직 연합에 포함되지 않은 국가만
                    int diff = Math.abs(graph[nx][ny] - graph[nowx][nowy]);
                    if (L <= diff && diff <= R) {
                        checked[nx][ny] = true; // 연합에 포함
                        idxlist.add(new int[]{nx, ny});
                        save += graph[nx][ny];
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        int val = save / idxlist.size();
        
        if (idxlist.size() == 1) {
            return false; // 연합이 형성되지 않음
        }
        
        // 연합 국가의 인구 조정
        for (int[] nowidx : idxlist) {
            graph[nowidx[0]][nowidx[1]] = val;
        }
        
        return true; // 연합이 형성됨
    }
}