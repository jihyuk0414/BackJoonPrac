import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int S= Integer.parseInt(oneline[1]);
        //한 방향으로 갈거다.

        int [] Narr = new int [N+1];

        String [] nline = br.readLine().split(" ");
        for (int i = 0 ; i<N ; i++)
            {
                Narr[i] = Integer.parseInt(nline[i]);
            }

        int start = 0 ;
        int end = 0 ;
        int cnt = Narr[start];
        int answer = Integer.MAX_VALUE;

        while (end <N)
            {
                if (cnt < S)
                {
                    end +=1;
                    cnt += Narr[end];
                } else if (cnt >= S )
                {
                    answer = Math.min(end-start+1,answer);
                    cnt -= Narr[start];
                    start+=1;
                } 
            }

        if(answer == Integer.MAX_VALUE)
        {
            answer = 0;
        }
        
        bw.write(answer+"");
        bw.close();
    
    }

}