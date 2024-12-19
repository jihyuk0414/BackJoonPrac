import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int onecnt = 0 ;
    static int zerocnt = 0 ;
    static int [][] map;
    static int [] answer = new int [2];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        long A = Long.parseLong(oneline[0]);
        long B = Long.parseLong(oneline[1]);
        long C = Long.parseLong(oneline[2]);
        

        bw.write(String.valueOf(ans(A,B,C)));
        bw.close();
        
    }

    public static long ans(long A, long B, long C)
    {
        if (B == 1)
        {
            return A % C; 
        }

        long now = ans(A,B/2, C);

        if (B %2 == 0 )
        {
            return (now*now)%C ;
        } else {
            return (now*now)%C *A%C;
        }
    }
}