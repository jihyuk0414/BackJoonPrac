import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String [] sarr = br.readLine().split(" ");
        int[] narr = new int[N];

        int k = Integer.parseInt(br.readLine());

        long totalsum = 0;
        for (int i =0; i<N ; i++)
            {
                narr[i] = Integer.parseInt(sarr[i]);
                totalsum += narr[i];
            }

        int start = 0 ;
        int end = N-1;
        long answer = 0 ;
        long nowsum = totalsum;

            //nowsum으로 하는데 

        while (end >=0)
            {
                if (nowsum > k)
                {
                    answer += 1;
                } 

                if (start == end)
                {
                    start = 0 ;
                    totalsum-= narr[end];
                    nowsum = totalsum;
                    end -=1 ;
                    continue;
                }

                nowsum -= narr[start];
                start += 1;

            }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        
    }
}