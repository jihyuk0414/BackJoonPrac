import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String [] oneline = br.readLine().split(" ");

        int [] Narr = new int [N+1];
        for (int i = 0 ; i<N ; i++)
            {
                Narr[i] = Integer.parseInt(oneline[i]); 
            }
        Narr[N] = Integer.MAX_VALUE;
        if (N ==1 )
        {
            bw.write("0");
            bw.close();
            return;
        }
        Arrays.sort(Narr);

        int start = 0;
        int end = N-1;
        int total = Narr[start]+Narr[end];
        int answer =0  ;

        while (end > start)
            { 
                if (total > M)
                {
                    total -= Narr[end];
                    end -=1;
                    total += Narr[end];
                } else if (total < M)
                {
                    total -= Narr[start];
                    start +=1;
                    total += Narr[start];
                } else {
                    answer +=1;
                    total -= Narr[start];
                    start +=1;
                    total += Narr[start];
                }
            }

        bw.write(answer+"");
        bw.close();
    
    }

}