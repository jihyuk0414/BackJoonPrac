import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // int [][] dp = new int [N+1];
        int [] milkarr = {0,1,2};
        int nowmilkindex = 0;

        String [] oneline = br.readLine().split(" ");
        int [] Narr = new int [N+1];

        for (int i = 0 ; i<N ; i++)
            {
                Narr[i+1] = Integer.parseInt(oneline[i]);
            }

        int answer=  0 ;

        for (int i = 1; i <=N; i++)
            {
                if(Narr[i] == milkarr[nowmilkindex])
                {
                    answer+=1 ;
                    nowmilkindex = (nowmilkindex+1) % 3 ; 
                }
            }

        bw.write(answer+"");
        bw.close();
        
    }

}