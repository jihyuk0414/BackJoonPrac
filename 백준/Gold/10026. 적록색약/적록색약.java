import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N ;
    static char [][] Narr;
    static char [][] Narr2;

    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};

    static int answerorigin,answerwrong = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Narr = new char [N][N]; 
        Narr2 = new char [N][N];
        boolean [][] visited1 = new boolean[N][N];
        boolean [][]visited2 = new boolean[N][N];

        for(int i = 0 ;i<N; i++)
            {
                String oneline = br.readLine();
                for (int j = 0 ; j<N ; j++)
                    {
                        Narr[i][j] = oneline.charAt(j);
                    }
            }

        for(int i = 0 ;i<N; i++)
            {
                for (int j = 0 ; j<N ; j++)
                    {
                        if(Narr[i][j] =='R' || Narr[i][j] =='G')
                        {
                            Narr2[i][j] = 'R';
                        } else {
                            Narr2[i][j] = 'B';
                        }
                    }
            }

        for (int i = 0 ; i<N ; i++)
            {
                for (int j =0 ; j<N ; j++)
                    {
                        if(!visited1[i][j])
                        {
                            find(i,j,Narr[i][j],visited1,Narr);
                            answerorigin +=1; 
                        }

                        if(!visited2[i][j])
                        {
                            find(i,j,Narr2[i][j],visited2,Narr2);
                            answerwrong+=1;
                        }
                    }
            }

        bw.write(answerorigin+" "+answerwrong);
        bw.close();
    
    }

    public static void find(int x, int y, char origin,boolean [][] visited, char [][] Narray)
    {
        visited[x][y] = true;
        
        for (int i = 0 ; i<4 ; i++)
            {
                int nx=  x+dx[i];
                int ny = y+dy[i];

                if(0<=nx && nx<N && 0<= ny && ny<N)
                {
                    if(!visited[nx][ny])
                    {
                        if(Narray[nx][ny] == origin)
                        {
                            find(nx,ny,origin,visited,Narray);
                        }
                    }
                }
            }
    }
  

}