import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputstr = br.readLine().split(" ");
        int N = Integer.parseInt(inputstr[0]);
        int K = Integer.parseInt(inputstr[1]);

        String [] inputstr2 = br.readLine().split(" ");
        int [] Narr = new int[N];
        for (int i = 0 ; i < N ;i++)
            {
                Narr[i] = Integer.parseInt(inputstr2[i]);
            }

        int start = 0 ;
        int answer = 0;
        int end = 0 ;
        int [] answerarr = new int [100000+1];
        while (end<N)
            {   
                if (answerarr[Narr[end]] < K)
                {
                    //아직들어갈수있으면
                    answerarr[Narr[end]] +=1 ;
                    end += 1;
                } else{
                    answerarr[Narr[start]]-=1;
                    start += 1;
                }

                answer = Math.max(answer, end-start);
            }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}