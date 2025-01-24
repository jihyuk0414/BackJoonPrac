import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int M = Integer.parseInt(oneline[1]);

        int [] Narr = new int [N+1];

        String [] twoline = br.readLine().split(" ");
        for (int i =0; i<N; i++)
            {
                Narr[i] = Integer.parseInt(twoline[i]);
            }

        int answer =0  ;
        int start = 0 ;
        int end = 0 ;
        int cnt = Narr[0];
        while (true)
            {
                if (end ==N)
                {
                    break;
                }
                
                if (cnt < M)
                {
                    cnt += Narr[++end];
                } else if (cnt>M){
                    cnt -= Narr[start++]; 
                } else {
                    answer +=1;
                    cnt += Narr[++end];
                }
            }

        bw.write(answer+"");
        bw.close();
    
    }

}