import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int K = Integer.parseInt(oneline[0]);
        int N = Integer.parseInt(oneline[1]);

        int [] Karr = new int [K];
        
        for (int i =0 ; i <K  ; i++)
            {
                Karr[i] = Integer.parseInt(br.readLine());
            }

        Arrays.sort(Karr);


        //이때는 index가 아닌, 값임에 주의하자
        
        long start = 1 ; 
        long end = Karr[Karr.length-1];

        long answer = 0 ;

        while (start<=end)
            {
                long mid = (start+end)/2;

                int howmany = 0;
                for(int i = 0 ; i<K ; i++)
                    {
                        howmany += (Karr[i]/mid);
                    }

                if(howmany < N)
                {
                    end = mid-1;
                } else {
                    answer = mid;
                    start = mid +1;
                }
            }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}