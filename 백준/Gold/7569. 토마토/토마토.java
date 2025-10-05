import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<String> answerlist = new ArrayList<>();
    static int M,N,H ;
    static List<Character> aeiou = new ArrayList<>();

    //오른쪽,아래,왼족,위,한칸위,한칸아래
    static int [] dx = new int [] {1,0,-1,0,0,0};
    static int [] dy = new int [] {0,-1,0,1,0,0};
    static int [] dz = new int [] {0,0,0,0,1,-1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");
        M = Integer.parseInt(oneline[0]);
        N = Integer.parseInt(oneline[1]);
        H = Integer.parseInt(oneline[2]);

        int [][][] map = new int [H][N][M];
        boolean [][][] visited = new boolean [H][N][M];
        
for (int i = 0; i < H; i++) {
    for (int j = 0; j < N; j++) {
        String[] twoline = br.readLine().split(" ");
        for (int x = 0; x < M; x++) {
            map[i][j][x] = Integer.parseInt(twoline[x]);
        }
    }
}

        Queue<int []> q = new LinkedList<>();
        int firstcnt = 0;
        for (int i = 0 ;i<H; i++)
            {
                for (int j = 0 ;j <N ; j++)
                    {
                        for (int x = 0 ; x<M; x++)
                            {
                                if(map[i][j][x] == 1)
                                {
                                    firstcnt+=1;
                                    q.add(new int [] {x,j,i,0});
                                }
                                else if(map[i][j][x] == -1)
                                {
                                    firstcnt+=1;
                                    
                                }
                            }
                    }
            }

        if(M*N*H == firstcnt)
        {
            bw.write("0");
            bw.close();
            return;
        }

        int answer = 0;

        while(!q.isEmpty())
            {
                int [] now = q.poll();

                int x = now[0];
                int y = now[1];
                int z = now[2];
                int cnt = now[3];
                answer = Math.max(answer,now[3]);

                visited[z][y][x]= true;

                for (int i = 0 ; i<6; i++)
                    {
                        int nx = x+dx[i];
                        int ny = y+dy[i];
                        int nz = z+dz[i];

                        if(0<= nx && nx <M && 0<= ny && ny <N && 0<= nz && nz<H&& !visited[nz][ny][nx] && map[nz][ny][nx] == 0)
                        {
                            map[nz][ny][nx] = 1;
                            q.add(new int [] {nx,ny,nz,cnt+1});
                        }
                    }
            }
        
        for (int i = 0 ;i<H; i++)
            {
                for (int j = 0 ;j <N ; j++)
                    {
                        for (int x = 0 ; x<M; x++)
                            {
                                if(map[i][j][x] == 0)
                                {
                                    bw.write("-1");
                                    bw.close();
                                    return;
                                }
                            }
                    }
            }

        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}