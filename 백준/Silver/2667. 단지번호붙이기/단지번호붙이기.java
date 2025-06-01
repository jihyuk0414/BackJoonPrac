import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int [] dx = new int [] {0,1,0,-1};
    static int [] dy = new int [] {1,0,-1,0};
    static int N;
    static int [][] map;
    static boolean [][]visited ; 
    static List<Integer> answerlist= new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int [N][N];
        visited = new boolean[N][N];
        for (int i = 0 ; i<N; i++)
            {
                String oneline = br.readLine();
                for (int j = 0 ;j<N; j++)
                    {
                        map[i][j] = Character.getNumericValue(oneline.charAt(j));
                    }
            }


        for (int i = 0 ; i<N; i++)
            {
                for (int j = 0 ;j<N; j++)
                    {
                        if(map[i][j] == 1 && visited[i][j] == false)
                        {
                            Queue<int []> q = new LinkedList<>();
                            q.add(new int[] {i,j});
                            visited[i][j] = true;
                            int cnt = 1;
                            while(!q.isEmpty())
                                {
                                    int [] now = q.poll();
                                    int nowx = now[0];
                                    int nowy = now[1];
                                    for (int z = 0; z<4 ; z++)
                                        {
                                            int nx = nowx+dx[z];
                                            int ny = nowy+dy[z];
                                            if(0<=nx && nx<N && 0<= ny && ny<N)
                                            {
                                                if(!visited[nx][ny]&&map[nx][ny] ==1)
                                                {
                                                    cnt+=1;
                                                    q.add(new int[]{nx,ny});
                                                    visited[nx][ny] = true;
                                                }
                                            }
                                        }
                                }

                            answerlist.add(cnt);
                        }
                        
                        visited[i][j] = true;
                    }
            }

        Collections.sort(answerlist);
        bw.write(String.valueOf(answerlist.size())+"\n");
        for (int c = 0 ; c<answerlist.size(); c++)
            {
                bw.write(String.valueOf(answerlist.get(c)));
                if(c!= answerlist.size()-1)
                {
                    bw.write("\n");
                }
            }
        bw.close();
    }
}