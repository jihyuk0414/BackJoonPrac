import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N ; 
    static boolean [] eaten ;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        int Q = Integer.parseInt(oneline[1]);

        eaten = new boolean[N+1];

        for (int i = 0 ; i<Q ; i++)
            {
                int origintarget = Integer.parseInt(br.readLine());
                int onelineanswer = 0;

                int target = origintarget;
                while(target >= 1 )
                    {
                        if (eaten[target])
                        {
                            onelineanswer = target;
                        }
                        target/=2;
                    }

                if(onelineanswer == 0 )
                {
                    eaten[origintarget] = true;
                }

                if (onelineanswer !=0 )
                {
                    bw.write(String.valueOf(onelineanswer));
                } else {
                    bw.write("0");
                }

                if(i!=Q-1)
                {
                    bw.write("\n");
                }
            }

        bw.close();





    }

}