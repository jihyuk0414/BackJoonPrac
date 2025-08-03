import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String [] Nstrarr = br.readLine().split(" ");
        int [] Narr = new int[N];

        for (int i = 0 ; i<N ; i++)
            {
                Narr[i] = Integer.parseInt(Nstrarr[i]);
            }
        //N
        
        int M = Integer.parseInt(br.readLine());

        String [] Mstrarr = br.readLine().split(" ");
        int [] Marr = new int[M];

        for (int i = 0 ; i<M ; i++)
            {
                Marr[i] = Integer.parseInt(Mstrarr[i]);
            }

        Arrays.sort(Narr);

        for (int i = 0 ; i<M ; i++)
            {
                int nowm = Marr[i];
                int start = 0 ;
                int end = N-1; 
                boolean find = false;

                while(start<=end)
                    {
                        int mid = (start+end)/2;
                        if(nowm == Narr[mid])
                        {
                            find = true ;
                            break;
                        } else if (nowm <Narr[mid])
                        {
                            end = mid-1;
                        } else {
                            start = mid+1;
                        }
                    }

                if(find)
                {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }

        bw.close();
        br.close();
    }
}