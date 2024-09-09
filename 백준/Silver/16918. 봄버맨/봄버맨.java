import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int R;
    static int C;
    static int N;
    static char[][] graph ; 
    static int cnt = 1;
    static int[]dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputarr = br.readLine().split(" ");
        
        R = Integer.parseInt(inputarr[0]);
        C = Integer.parseInt(inputarr[1]);
        N = Integer.parseInt(inputarr[2]);

        graph = new char[R][C];

        for (int i=0; i<R ; i++)
            {
                String line = br.readLine(); 
                for (int j = 0; j < C; j++) {
                    graph[i][j] = line.charAt(j);  // 각각의 값을 그래프에 저장
                }
            }

        while(cnt<N)
            {
                cnt +=1 ;
                if (cnt%2 ==0)
                {
                    //폭탄채우기
                    for (int i=0; i<R ; i++)
                    {
                        for(int j=0;j<C; j++)
                        {
                            if(graph[i][j] == ('.'))
                            {
                                graph[i][j]='O';
                            }
                            else if(graph[i][j]== ('O'))
                            {
                                graph[i][j]='X'; //곧터지는폭탄.
                            }
                        }
                    }
                }else{
                    //터뜨리기
                    for (int i=0; i<R ; i++)
                    {
                        for(int j=0;j<C; j++)
                        {
                            if(graph[i][j] == ('X'))
                            {
                                graph[i][j]='.';
                                for (int z=0 ;z<4; z++)
                                    {
                                        int nx = i+dx[z];
                                        int ny= j+dy[z];
                                        if (nx>=0&& nx<R && ny>=0 && ny<C && (graph[nx][ny]=='O'))
                                        {
                                            graph[nx][ny] = '.';
                                        }
                                        
                                    }
                            }
                        }
                    }
                }
            }

        for (int i=0; i<R ; i++)
            {
                    for(int j=0;j<C; j++)
                    {
                        if(graph[i][j]==('X'))
                        {
                            graph[i][j]='O';
                        }
                    }
            }

        

        for (int i=0; i<R ; i++)
            {
                for(int j=0;j<C; j++)
                    {
                        bw.write(graph[i][j]);
                    }
                bw.write("\n") ; 
            }

        bw.flush();
        bw.close();
        
        
    }
}