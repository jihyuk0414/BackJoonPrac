import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] Narr = new int[N];

        String [] oneline = br.readLine().split(" ");
        for (int i = 0 ; i<N; i++)
            {
                Narr[i] = Integer.parseInt(oneline[i]);
            }
        Arrays.sort(Narr);
        int X = Integer.parseInt(br.readLine());

        int start = 0 ;
        int end = N-1;
        int cnt = Narr[start]+Narr[end];
        int answer = 0;

        while (start<end)
            {
                if (cnt < X)
                {
                    cnt -= Narr[start];
                    start +=1;
                    cnt += Narr[start];
                } else if (cnt > X)
                {
                    cnt -= Narr[end];
                    end -=1;
                    cnt += Narr[end];
                } else {
                    answer +=1;
                    cnt -= Narr[start];
                    start +=1;
                    cnt += Narr[start];
                    
                }
            }

        bw.write(answer+"");
        bw.close();
    
    }

}