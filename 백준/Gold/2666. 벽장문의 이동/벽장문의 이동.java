import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M,answer; 
    static boolean[] whereisdoor;
    static int [] marr;

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        String [] doorline = br.readLine().split(" ");

         M = Integer.parseInt(br.readLine());

        answer = Integer.MAX_VALUE ;

        marr = new int [M];

        for (int z = 0 ; z<M ;z++)
            {
                marr[z] = Integer.parseInt(br.readLine());
            }

        DFS(Integer.parseInt(doorline[0]),Integer.parseInt(doorline[1]),0,0);

        bw.write(answer+"");
        bw.close();


    }

    public static void DFS(int leftopen, int rightopen, int depth , int cnt)
    {
        if (depth == M)
        {
            answer=  Math.min(answer, cnt);
            return;
        }

        int leftval = Math.abs(marr[depth]-leftopen);
        
        int rightval = Math.abs(rightopen - marr[depth]);

        DFS(marr[depth],rightopen,depth+1,cnt+leftval);
        DFS(leftopen,marr[depth],depth+1,cnt+rightval);
    }
}