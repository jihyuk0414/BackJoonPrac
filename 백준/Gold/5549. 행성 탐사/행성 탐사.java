import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] oneline = br.readLine().split(" ");
        int M = Integer.parseInt(oneline[0]);
        int N = Integer.parseInt(oneline[1]);
        int K = Integer.parseInt(br.readLine());

        char [][] map = new char[M][N];
        int [][] jio = new int[M][N];

        for (int i = 0 ; i<M; i ++)
            {
                String Mline = br.readLine();
                for (int j = 0 ; j<N ; j++)
                    {
                        map[i][j] = Mline.charAt(j);
                        if(map[i][j]=='J')
                        {
                            jio[i][j] = 0 ;
                        } else if (map[i][j] == 'I')
                        {
                            jio[i][j] = 1 ;
                        } else {
                            jio[i][j] = 2;
                        }
                    }
            }

        int [][][] dp = new int [M+1][N+1][3];

        for (int i = 1; i<=M; i ++)
            {
                for (int j = 1; j <= N ; j++)
                    {
                        dp[i][j][0] = dp[i-1][j][0]+dp[i][j-1][0]-dp[i-1][j-1][0];
                        dp[i][j][1] = dp[i-1][j][1]+dp[i][j-1][1]-dp[i-1][j-1][1];
                        dp[i][j][2] = dp[i-1][j][2]+dp[i][j-1][2]-dp[i-1][j-1][2];
                        dp[i][j][jio[i-1][j-1]]+=1;
                    }
            }

        for (int i = 0; i<K; i ++)
            {
                String [] kline = br.readLine().split(" ");
                int x1 = Integer.parseInt(kline[0]);
                int y1 = Integer.parseInt(kline[1]);
                int x2 = Integer.parseInt(kline[2]);
                int y2 = Integer.parseInt(kline[3]);

                //joi순으로 출력 (0,2,1)
                bw.write(String.valueOf(dp[x2][y2][0]-dp[x1-1][y2][0]-dp[x2][y1-1][0]+dp[x1-1][y1-1][0]) +" ");
                bw.write(String.valueOf(dp[x2][y2][2]-dp[x1-1][y2][2]-dp[x2][y1-1][2]+dp[x1-1][y1-1][2]) +" ");
                bw.write(String.valueOf(dp[x2][y2][1]-dp[x1-1][y2][1]-dp[x2][y1-1][1]+dp[x1-1][y1-1][1]) +" ");
                bw.write("\n");
            }
        bw.close();
    

        

    
    }
    
}