import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        long M = Long.parseLong(oneline[1]);

        int [] Narr = new int[N];
        String [] twoline = br.readLine().split(" ");
        for (int i = 0 ; i<N; i++)
            {
                Narr[i] = Integer.parseInt(twoline[i]);
            }

        Arrays.sort(Narr);

        int answer = 0 ;

        //앞 뒤로
        int idx = 0 ;
        int left = 0 ;
        int right = N-1;
        while (left < right)
            {
                if (right < 0 || left > N-1)
                {
                    break;
                }

                int a = Narr[left];
                int b = Narr[right];

                if(a+b >= M)
                {
                    answer +=1;
                    left+=1;
                    right -=1;
                }
                else
                {
                    left +=1;
                }
            }
        bw.write(answer+"");
        bw.close();
    }
}