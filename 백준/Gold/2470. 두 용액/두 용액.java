import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String [] strarr = br.readLine().split(" ");
        long [] narr = new long [N] ; 

        for (int i = 0 ; i<N ; i++)
            {
                narr[i] = Long.parseLong(strarr[i]);
            }

        Arrays.sort(narr);

        int start = 0 ;
        int end = N-1;

        long a = 0L;
        long b= 0L;
        long answer = Long.MAX_VALUE ;

        while (start< end)
            {
                long leftanswer = narr[start];
                long rightanswer = narr[end];

                if (Math.abs(leftanswer+rightanswer) < answer)
                {
                    a = leftanswer;
                    b = rightanswer;
                    answer = Math.abs(leftanswer+rightanswer);
                }

                if (leftanswer+rightanswer <= 0)
                {
                    start += 1;
                } else {
                    end -= 1;
                }
                
            }
    
        bw.write(String.valueOf(a) + " " + String.valueOf(b));
        bw.close();
    }
}