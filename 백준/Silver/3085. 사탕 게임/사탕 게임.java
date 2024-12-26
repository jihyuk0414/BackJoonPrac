import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ;
    static char[][] map;
    static int answereat = 0 ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i = 0 ; i<N ; i++)
            {
                String oneline = br.readLine();
                for (int j = 0 ;j<N ; j++)
                    {
                        map[i][j] = oneline.charAt(j);
                    }
            }

        int [] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};

        for (int i =0  ;i<N ; i++)
            {
                for (int j = 0 ; j<N; j++)
                    {
                        char nowval = map[i][j];
                        for (int z = 0 ; z<4 ; z++)
                            {
                                int nx = i+dx[z];
                                int ny = j+dy[z];
                                if(0<=nx && nx<N && 0<=ny && ny<N)
                                {
                                    if(nowval != map[nx][ny])
                                    {
                                        char temp = map[i][j];
                                        map[i][j] = map[nx][ny];
                                        map[nx][ny] = temp;
                                        eat();
                                        char temp2 = map[nx][ny];
                                        map[nx][ny] = map[i][j];
                                        map[i][j] = temp2;
                                    }
                                }
                            }
                    }
            }

        bw.write(String.valueOf(answereat));
        bw.close();
        
    }

 public static void eat() {
    // 가로 고르기
    for (int i = 0; i < N; i++) {
        int cnt = 1;
        char now = map[i][0];
        for (int j = 1; j < N; j++) {
            if (map[i][j] == now) {
                cnt++;
            } else {
                cnt = 1;
                now = map[i][j];
            }
            answereat = Math.max(answereat, cnt);
        }
    }

    // 세로 고르기
    for (int i = 0; i < N; i++) {
        int cnt = 1;
        char now = map[0][i];
        for (int j = 1; j < N; j++) {
            if (map[j][i] == now) {
                cnt++;
            } else {
                cnt = 1;
                now = map[j][i];
            }
            answereat = Math.max(answereat, cnt);
        }
    }
}
}