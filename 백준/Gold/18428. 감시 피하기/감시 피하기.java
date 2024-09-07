import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

        static int [] dx = {0,-1,0,1};
    static int [] dy = {-1,0,1,0};
    static String answer = "NO";
    static int N ;
    static char[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        for (int i =0;i<N; i++)
            {
               String line = br.readLine().replaceAll(" ", ""); // 공백 제거
                for (int j = 0; j < N; j++) {
                    graph[i][j] = line.charAt(j);
                }
            }

        DFS(deepCopy(graph),0);

        bw.write(answer);
        bw.flush();
        bw.close();
        
    }

    public static boolean check(char [][] graph)
    {
        for (int i = 0 ; i<N ; i++)
            {
                for (int j = 0 ; j<N ; j++)
                    {
                        if(graph[i][j]=='T') 
                        {
                            for (int z = 0 ; z<4; z++)
                                {
                                    int nx =i+dx[z];
                                    int ny= j+dy[z];
                                    while(0<=nx && nx<N && 0<=ny && ny<N)
                                        {
                                            if(graph[nx][ny]=='O')
                                            {
                                                break;
                                            }
                                            if(graph[nx][ny]=='S')
                                            {
                                                return false;
                                            }
                                            nx += dx[z];
                                            ny+=dy[z];
                                        }
                                }
                        }
                    }
            }

        return true;
    }

    public static void DFS(char [][] graph, int depth)
    {
        if (depth == 3)
        {
            if(check(graph) == true)
            {
                answer = "YES";
            }
            return;
        }

        for (int i = 0 ; i<N; i++)
            {
                for (int j =0; j<N;j++)
                    {
                        if(graph[i][j]=='X')
                        {
                            graph[i][j] = 'O';
                            DFS(graph,depth+1);
                            graph[i][j] = 'X';
                        }
                    }
            }


        }

    public static char[][] deepCopy(char[][] originalarr)
    {
        char[][] chararr = new char[N][N];
        for(int i =0; i<N ;i++)
            {
                chararr[i] = originalarr[i].clone();
            }

        return chararr;
    }

}