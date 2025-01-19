import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static Map<Long,Long> answermap = new HashMap<>();
    static long N,P,Q,answer;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");
        N =Long.parseLong(oneline[0]);
         P =Long.parseLong(oneline[1]);
        Q =Long.parseLong(oneline[2]);

        bw.write(topdown(N)+"");
        bw.close();
    }

    public static long topdown(long N)
    {
        if(N == 0 )
        {
            return 1;
        }

        if (answermap.containsKey(N)){
            return answermap.get(N);
        }

        long now = topdown(N/P)+topdown(N/Q);
        answermap.put(N,now);
        return now;
    }
}