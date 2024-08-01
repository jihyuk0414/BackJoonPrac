import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int[][] Nlist;  // Nlist를 클래스 변수로 선언
    private static int N;  // N을 클래스 변수로 선언
    private static int M; 

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int z = 0 ; z<T; z++)
        {
            M = scanner.nextInt();
            N = scanner.nextInt();
            int K = scanner.nextInt();

            Nlist = new int[N][M] ;

            for (int i =  0 ; i<K ; i++)
            {
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    Nlist[y][x] = 1;
            }

            int answer = 0;

            for (int i =0; i<N; i++)
                {
                    for(int j =0; j<M ; j++)
                        {
                            if (Nlist[i][j] == 1) {  // 배추가 있는 경우
                            Nlist[i][j] = 0;  // 방문한 셀을 0으로 표시
                            DFS(i, j);  // DFS 호출
                            answer++;  // 새로운 배추밭 발견 시 카운트 증가
                            }
                        }
                }
            System.out.println(answer);
        }
    }

    public static void DFS(int x, int y)
    {
        for (int i = 0 ; i<4 ; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) 
                {
                    if (Nlist[nx][ny]==1)
                    {
                        Nlist[nx][ny] = 0 ;
                        DFS(nx,ny);
                    }
                }
            }
    }
}