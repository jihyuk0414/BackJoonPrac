import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int R ; 
    static int C;
    static char [] [] map ;
    static boolean[][] visited ;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int answer = 1;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] oneline = br.readLine().split(" ");
        R = Integer.parseInt(oneline[0]);
        C = Integer.parseInt(oneline[1]);
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0 ; i<R ; i++)
            {
                String twoline = br.readLine();
                for (int j = 0; j<C ; j++)
                    {
                        map[i][j] = twoline.charAt(j);
                    }
            }

        List<Character> newlist = new ArrayList<>(Arrays.asList(map[0][0]));
        visited[0][0] = true;
        DFS(0,0,newlist,1);

        bw.write(String.valueOf(answer));
        bw.close();

    }

    public static void DFS(int x , int y, List<Character> beforelist, int depth)
    {
        answer = Math.max(answer,depth);
        
        char now = map[x][y];
        
        for (int i = 0 ; i<4 ; i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(0<=nx && nx<R && 0<=ny && ny<C)
                {
                    if(!visited[nx][ny] && !beforelist.contains(map[nx][ny]))
                    {
                        visited[nx][ny] = true;
                        beforelist.add(map[nx][ny]);
                        DFS(nx,ny,beforelist,depth+1);
                        visited[nx][ny] = false;
                        beforelist.remove(beforelist.size()-1);
                    }
                }
            }
    }



    
}