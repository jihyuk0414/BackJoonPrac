import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i<T ;i++)
            {
                String[] inputstrarr = br.readLine().split(" ");
                int N = Integer.parseInt(inputstrarr[0]);
                int M = Integer.parseInt(inputstrarr[1]);

                String [] Astrarr = br.readLine().split(" ");
                int [] Aarr = new int[N];

                for(int j =0 ; j<N; j++)
                    {
                        Aarr[j] = Integer.parseInt(Astrarr[j]);
                    }
                
                String [] Bstrarr = br.readLine().split(" ");
                int [] Barr = new int[M];

                for(int j = 0 ; j <M ; j++)
                    {
                        Barr[j] = Integer.parseInt(Bstrarr[j]);
                    }
                Arrays.sort(Aarr);
                Arrays.sort(Barr);
                

                int ap = 0; 
                int bp = 0 ;
                int ans = 0 ;

                while (ap<N )
                    {
                        if(bp<M && Aarr[ap]>Barr[bp])
                        {
                            bp += 1; 
                        } else {
                            ans += bp; 
                            ap+=1;
                        }
                    }

                bw.write(String.valueOf(ans));
                bw.write("\n");
            }

        bw.close();
        br.close();

        
    }
}