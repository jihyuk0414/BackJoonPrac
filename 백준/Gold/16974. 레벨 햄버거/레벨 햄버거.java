import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long [] pcnt ;
    static long [] totalcnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        long X  = Long.parseLong(oneline[1]);
        pcnt = new long[N+1];
        totalcnt = new long[N+1];
        pcnt[0] = 1;
        totalcnt[0] =1 ;

        for (int i = 1; i<=N; i++)
            {
                pcnt[i] = pcnt[i-1]*2 +1;
                totalcnt[i] = totalcnt[i-1]*2+3;
            }

        bw.write(findpcnt(N,X)+"");
        bw.close();
    
    }

    public static long findpcnt(int depth, long idx)
    {
        if (depth == 0)
        {
            return idx>=1? 1 : 0;
        }

        if (idx <=0)
        {
            return 0; //이해 안됨
        }

        if (idx == totalcnt[depth-1]+2)
        {
            return pcnt[depth-1]+1;
        } else if (idx < totalcnt[depth-1]+2)
        {
            return findpcnt(depth-1, idx-1);
        } else if(idx >  totalcnt[depth-1]+2) 
        {
            return findpcnt(depth-1,idx-totalcnt[depth-1]-2)+pcnt[depth-1]+1;
        } else {
            return pcnt[depth];
        }
    }
}