import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N = 0;
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        long M = Long.parseLong(oneline[1]);

        long [] Narr = new long[N];
        for(int i = 0 ; i<N; i++)
            {
                Narr[i] = Long.parseLong(br.readLine());
            }

        Arrays.sort(Narr);

        int start = 0;
        int end = 0 ;
        while(end<N)
            {
                if(Narr[end]-Narr[start] > M)
                {
                    answer = Math.min(answer, Narr[end]-Narr[start]);
                    start +=1;
                }
                else if (Narr[end]- Narr[start] == M)
                {
                    answer = M;
                    break;
                }
                else
                {
                    end +=1;
                }
            }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}