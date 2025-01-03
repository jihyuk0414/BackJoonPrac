import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ;
    static int M ;
    static int x  ;
    static int y ;
    static int K ;
    static int [] howgo;

    static int left = 0;
    static int mid = 0;
    static int right = 0;
    static int up = 0;
    static int down = 0;
    static int special = 0;

    static int [][] map ;
    static int [] dx=  {0,0,0,-1,1};
    static int [] dy = {0,1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        M = Integer.parseInt(oneline[1]);
        x = Integer.parseInt(oneline[2]);
        y = Integer.parseInt(oneline[3]);
        K = Integer.parseInt(oneline[4]);

        map = new int [N][M];

        for (int i = 0 ; i<N ;i++)
            {
                String [] twoline = br.readLine().split(" ");
                for (int j = 0 ; j<M; j++)
                    {
                        map[i][j] = Integer.parseInt(twoline[j]);
                    }
            }

        String [] howgostr = br.readLine().split(" ");
        howgo = new int [howgostr.length];
        for (int i = 0 ; i<howgostr.length ; i++)
            {
                howgo[i] = Integer.parseInt(howgostr[i]);
            }

        map[x][y] = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i<K ; i++)
            {
                int nextgo = howgo[i];
                int nx = x+dx[nextgo];
                int ny = y+dy[nextgo];
                if (nx<0 || nx>=N || ny<0 || ny>=M)
                {
                    continue;
                }
                
                roll(nextgo);
                
                if(map[nx][ny] ==0 )
                {
                    map[nx][ny] = special;
                } else{
                    special = map[nx][ny];
                    map[nx][ny] = 0;
                }
                
                x= nx;
                y= ny;

                sb.append(String.valueOf(mid)+"\n");
            }

        bw.write(sb.toString());
        bw.close();
        
    }

    public static void roll (int direction)
    {
        if (direction ==1 )
        {
            int midsave = mid;
            int leftsave = left;
            int rightsave = right;
            int specialsave = special;
            
            mid = leftsave;
            right = midsave;
            special = rightsave;
            left = specialsave;
        } else if (direction == 2 )
        {
            int midsave = mid;
            int leftsave = left;
            int rightsave = right;
            int specialsave = special;
            
            mid = rightsave;
            right = specialsave;
            special = leftsave;
            left = midsave;
        }else if (direction == 3 )
        {
            int midsave = mid;
            int upsave = up;
            int downsave = down;
            int specialsave = special;
            
            mid = downsave;
            down = specialsave;
            special = upsave;
            up = midsave;
        }else if (direction == 4 )
        {
            int midsave = mid;
            int upsave = up;
            int downsave = down;
            int specialsave = special;
            
            mid = upsave;
            down = midsave;
            special = downsave;
            up = specialsave;
        }
    }
}