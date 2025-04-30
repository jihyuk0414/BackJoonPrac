import java.util.*;
import java.io.*;

public class Main {
    static int N = 0;
    static int[][] Narr;
    static int[][] saveNarr;
    static int answer = 0; // 최댓값을 구하는 문제이므로 0으로 초기화
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException { // IOException 추가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Narr = new int[N][N];
        saveNarr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] oneline = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                Narr[i][j] = Integer.parseInt(oneline[j]);
            }
        }

        // 초기 상태 저장
        saveBackup();
        
        // 5번의 이동을 모든 방향으로 시도
        for (int dir = 0; dir < 4; dir++) {
            dojob(0, dir);
        }
        
        // 결과 출력
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    // 배열 상태 백업
    public static void saveBackup() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                saveNarr[i][j] = Narr[i][j];
            }
        }
    }

    // 배열 상태 복원
    public static void restoreBackup() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Narr[i][j] = saveNarr[i][j];
            }
        }
    }

    // 배열에서 최대값 찾기
    public static int maxcnt() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, Narr[i][j]);
            }
        }
        return max;
    }

    public static void dojob(int depth, int wherego) {
        // 5번 이동 후 최대값 갱신
        if (depth == 5) {
            answer = Math.max(answer, maxcnt());
            return;
        }

        // 현재 상태 백업
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = Narr[i][j];
            }
        }

        // 방향에 따른 처리
        if (wherego == 0) { // 오른쪽
            moveRight();
        } else if (wherego == 1) { // 아래쪽
            moveDown();
        } else if (wherego == 2) { // 왼쪽
            moveLeft();
        } else if (wherego == 3) { // 위쪽
            moveUp();
        }

        // 다음 단계 탐색
        for (int nextDir = 0; nextDir < 4; nextDir++) {
            dojob(depth + 1, nextDir);
        }

        // 상태 복원
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Narr[i][j] = temp[i][j];
            }
        }
    }

    // 오른쪽으로 이동
    public static void moveRight() {
        for (int i = 0; i < N; i++) {
            List<Integer> values = new ArrayList<>();
            
            // 0이 아닌 값들을 모으기
            for (int j = N - 1; j >= 0; j--) {
                if (Narr[i][j] != 0) {
                    values.add(Narr[i][j]);
                }
            }
            
            // 병합 처리
            List<Integer> merged = new ArrayList<>();
            int idx = 0;
            while (idx < values.size()) {
                if (idx + 1 < values.size() && values.get(idx).equals(values.get(idx + 1))) {
                    merged.add(values.get(idx) * 2);
                    idx += 2;
                } else {
                    merged.add(values.get(idx));
                    idx += 1;
                }
            }
            
            // 결과를 배열에 적용
            Arrays.fill(Narr[i], 0); // 행을 0으로 초기화
            for (int j = 0; j < merged.size(); j++) {
                Narr[i][N - 1 - j] = merged.get(j);
            }
        }
    }

    // 왼쪽으로 이동
    public static void moveLeft() {
        for (int i = 0; i < N; i++) {
            List<Integer> values = new ArrayList<>();
            
            // 0이 아닌 값들을 모으기
            for (int j = 0; j < N; j++) {
                if (Narr[i][j] != 0) {
                    values.add(Narr[i][j]);
                }
            }
            
            // 병합 처리
            List<Integer> merged = new ArrayList<>();
            int idx = 0;
            while (idx < values.size()) {
                if (idx + 1 < values.size() && values.get(idx).equals(values.get(idx + 1))) {
                    merged.add(values.get(idx) * 2);
                    idx += 2;
                } else {
                    merged.add(values.get(idx));
                    idx += 1;
                }
            }
            
            // 결과를 배열에 적용
            Arrays.fill(Narr[i], 0); // 행을 0으로 초기화
            for (int j = 0; j < merged.size(); j++) {
                Narr[i][j] = merged.get(j);
            }
        }
    }

    // 위쪽으로 이동
    public static void moveUp() {
        for (int j = 0; j < N; j++) {
            List<Integer> values = new ArrayList<>();
            
            // 0이 아닌 값들을 모으기
            for (int i = 0; i < N; i++) {
                if (Narr[i][j] != 0) {
                    values.add(Narr[i][j]);
                }
            }
            
            // 병합 처리
            List<Integer> merged = new ArrayList<>();
            int idx = 0;
            while (idx < values.size()) {
                if (idx + 1 < values.size() && values.get(idx).equals(values.get(idx + 1))) {
                    merged.add(values.get(idx) * 2);
                    idx += 2;
                } else {
                    merged.add(values.get(idx));
                    idx += 1;
                }
            }
            
            // 결과를 배열에 적용
            for (int i = 0; i < N; i++) {
                Narr[i][j] = 0; // 열을 0으로 초기화
            }
            for (int i = 0; i < merged.size(); i++) {
                Narr[i][j] = merged.get(i);
            }
        }
    }

    // 아래쪽으로 이동
    public static void moveDown() {
        for (int j = 0; j < N; j++) {
            List<Integer> values = new ArrayList<>();
            
            // 0이 아닌 값들을 모으기
            for (int i = N - 1; i >= 0; i--) {
                if (Narr[i][j] != 0) {
                    values.add(Narr[i][j]);
                }
            }
            
            // 병합 처리
            List<Integer> merged = new ArrayList<>();
            int idx = 0;
            while (idx < values.size()) {
                if (idx + 1 < values.size() && values.get(idx).equals(values.get(idx + 1))) {
                    merged.add(values.get(idx) * 2);
                    idx += 2;
                } else {
                    merged.add(values.get(idx));
                    idx += 1;
                }
            }
            
            // 결과를 배열에 적용
            for (int i = 0; i < N; i++) {
                Narr[i][j] = 0; // 열을 0으로 초기화
            }
            for (int i = 0; i < merged.size(); i++) {
                Narr[N - 1 - i][j] = merged.get(i);
            }
        }
    }
}