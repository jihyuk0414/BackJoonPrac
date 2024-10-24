import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long A;
    static long B;
    static long C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputarr = br.readLine().split(" ");
        A = Integer.parseInt(inputarr[0]);
        B = Integer.parseInt(inputarr[1]);
        C = Integer.parseInt(inputarr[2]);

        bw.write(String.valueOf(dojob(A,B)));
        bw.close();

    }

    public static long dojob(long A, long val)
    {
        if (val == 1)
        {
            return A%C;
        }

        long ans = dojob(A, val/2);

        if(val%2 == 1)
        {
            return (ans * ans % C) * A % C;
        }
        return (ans * ans % C);
    }
}