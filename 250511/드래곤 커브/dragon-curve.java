import java.util.*;
import java.io.*;

public class Main {

    static int N; 
    static int [][] whattodo;
    static int [] dx = new int [] {0,-1,0,1}; //우,위,좌,아
    static int [] dy = new int [] {1,0,-1,0};
    static boolean [][] map = new boolean[101][101];
    static int answer = 0 ;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        whattodo = new int [N][4];
        for (int i = 0; i < N; i++) {
            String[] oneline = br.readLine().split(" ");
            int x = Integer.parseInt(oneline[0]);
            int y = Integer.parseInt(oneline[1]);
            int d = Integer.parseInt(oneline[2]);
            int g = Integer.parseInt(oneline[3]);

            run(x, y, d, g);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i < 99 && j < 99 && map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();

    }

    public static void run (int x, int y, int d, int g)
    {
        List<Integer> direction = new ArrayList<>();

        direction.add(d);

        for (int i = 0 ; i<g; i++)
        {
            for (int j = direction.size()-1; j>=0 ; j--)
            {
                direction.add((direction.get(j)+1)%4);
            }
        }

        map[x][y] = true;

        for (int i = 0 ; i<direction.size(); i++)
        {
            x = x +dx[direction.get(i)];
            y = y+ dy[direction.get(i)];
            map[x][y] = true;
        }


    }
}