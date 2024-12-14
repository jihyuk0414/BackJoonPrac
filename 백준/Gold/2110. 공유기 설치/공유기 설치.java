import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ;
    static int C ; 
    static int [] Narr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        N = Integer.parseInt(oneline[0]);
        C = Integer.parseInt(oneline[1]);

       Narr = new int [N];
        
        for (int i =0 ; i<N ; i++)
            {
                Narr[i] = Integer.parseInt(br.readLine());
            }

        Arrays.sort(Narr);

        long min = 1 ;
        long max = Narr[N-1]-Narr[0];
        long answer = 0 ;

        while(min <= max)
            { 
                long mid = (min+max)/2;

                if(cando(mid))
                {
                    answer = mid;
                    min = mid+1;
                } else {
                    max = mid-1;
                }
                
            }

        bw.write(String.valueOf(answer));
        bw.close();
    }

    public static boolean cando(long distance)
    {
        int cnt = 1 ; //처음거는 픽스
        int beforeindex = 0;
        
        for (int i =1 ; i<N ; i++)
            {
                if (Narr[i] - Narr[beforeindex] >= distance )
                {
                    beforeindex = i ;
                    cnt+=1; 
                }
            }

        if (cnt >= C)
        {
            return true;
        }
        return false;
    }
}