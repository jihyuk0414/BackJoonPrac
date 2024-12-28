import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int R,C,N; 
    static char [][] map;
    static int [][] cntmap;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] oneline = br.readLine().split(" ");
        R = Integer.parseInt(oneline[0]);
        C = Integer.parseInt(oneline[1]);
        N = Integer.parseInt(oneline[2]);
        map = new char[R][C];
        cntmap = new int[R][C];
        
        if (N == 1) {
            for (int i = 0; i < R; i++) {
                bw.write(br.readLine() + "\n");
            }
            bw.close();
            return;
        }

        // N이 짝수면 전체 폭탄
        if (N % 2 == 0) {
            for (int i = 0; i < R; i++) {
                br.readLine();  // 입력은 받아야 함
                for (int j = 0; j < C; j++) {
                    bw.write('O');
                }
                bw.write('\n');
            }
            bw.close();
            return;
        }
        
        // 초기 맵 입력
        for (int i = 0; i < R; i++) {
            String twoline = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = twoline.charAt(j);
            }
        }
        
        // N값 조정 (패턴 반복 고려)
        if (N % 4 == 1) N = 5;
        else if (N % 4 == 3) N = 3;

        // 폭발 시뮬레이션
        simulate();

        // 결과 출력
        for (int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                bw.write(String.valueOf(map[i][j]));
            }
            bw.write("\n");
        }
        bw.close();
    }
    
    public static void simulate() {
        char[][] temp = new char[R][C];
        if (N == 3) {
            // 모든 칸을 폭탄으로 채움
            for (int i = 0; i < R; i++) {
                Arrays.fill(temp[i], 'O');
            }
            // 원래 폭탄 위치에서 폭발
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'O') {
                        temp[i][j] = '.';
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                                temp[nx][ny] = '.';
                            }
                        }
                    }
                }
            }
        } else { // N == 5
            // 3초 상태를 먼저 만듦
            char[][] state3 = new char[R][C];
            for (int i = 0; i < R; i++) {
                Arrays.fill(state3[i], 'O');
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'O') {
                        state3[i][j] = '.';
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                                state3[nx][ny] = '.';
                            }
                        }
                    }
                }
            }
            
            // 5초 상태를 만듦
            for (int i = 0; i < R; i++) {
                Arrays.fill(temp[i], 'O');
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (state3[i][j] == 'O') {
                        temp[i][j] = '.';
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                                temp[nx][ny] = '.';
                            }
                        }
                    }
                }
            }
        }
        map = temp;
    }
}