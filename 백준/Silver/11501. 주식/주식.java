import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(T > 0)
            {
                int N = Integer.parseInt(br.readLine());
                String [] oneline2 =br.readLine().split(" ");
                int [] Narr = new int [N];
                int maxcnt = 0 ;
                long answer = 0 ;
                for (int i = 0 ; i<N; i++)
                    {
                        Narr[i] = Integer.parseInt(oneline2[i]);
                    }

                //거꾸로

                for (int i = N-1; i>= 0; i--)
                    {
                        if (Narr[i] < maxcnt)
                        {
                            answer = answer + (maxcnt - Narr[i]);
                        }
                        else
                        {
                            maxcnt = Narr[i];
                        }
                    }

                sb.append(answer+"\n");

                T-=1;
            }

        sb.deleteCharAt(sb.length()-1);
        bw.write(sb.toString());
        bw.close();


        
    }

}