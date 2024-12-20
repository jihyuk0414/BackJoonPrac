import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    static int N ; 
    static StringBuilder sb = new StringBuilder();
    static int cnt;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        hanoi(N,1,3);
        bw.write(String.valueOf(cnt) +"\n");
        bw.write(sb.toString());
        bw.close();
        
    }

    public static void hanoi(int N, int start, int target)
    {
        cnt +=1;
        
        if (N ==1)
        {
            sb.append(String.valueOf(start) + " "+ String.valueOf(target) +"\n");
            return;
        }

        int notvisit = (6-start-target);
        //n-1개를 안간곳에 넣고
        hanoi(N-1, start, notvisit);

        //1개를 N으로 보내고
        sb.append(String.valueOf(start) + " "+ String.valueOf(target) +"\n");

        //n-1개를 다시 목표로
        hanoi(N-1, notvisit, target);

        
    }
}