import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int M = Integer.parseInt(oneline[1]);

        int [] Narr = new int [N];
        int maxnum = 0;
        int sum = 0;
        for (int i = 0 ; i<N; i++)
            {
                Narr[i] = Integer.parseInt(br.readLine());
                sum += Narr[i];
                maxnum = Math.max(maxnum,Narr[i]);
            }
        int answer = sum;

        int left = maxnum;
        int right = sum;
        while (left <= right)
            {
                int nowval = (left)+(right-left)/2;

                if (cal(nowval,Narr,M))
                {
                    answer = Math.min(answer,nowval);
                    right = nowval -1;
                }
                else
                {
                    left = nowval +1; 
                }
            }

        bw.write(answer+"");
        bw.close();
    }
    

    public static boolean cal(int nowval, int [] Narr, int M)
    {
        int cnt = 1;
        int remain = nowval;
        
        for (int i = 0 ; i <Narr.length; i++)
            {
                if(Narr[i] > nowval)
                {
                    return false;
                }

                if(remain<Narr[i])
                {
                    cnt +=1;
                    remain = nowval;
                }

                remain -= Narr[i];
            }
        return cnt <= M;
    }
}