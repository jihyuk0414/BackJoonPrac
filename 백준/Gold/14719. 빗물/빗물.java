import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int H = Integer.parseInt(oneline[0]);
        int W = Integer.parseInt(oneline[1]);

        int [] map = new int [W];
        String [] twoline = br.readLine().split(" ");
        for (int i = 0 ; i<W; i++)
            {
                map[i] = Integer.parseInt(twoline[i]);
            }
        int [] leftmaxarr= new int [W];
        int leftmax = map[0];
        for (int i =1; i<W; i++)
            {
                leftmax = Math.max(map[i],leftmax);
                leftmaxarr[i] = leftmax;
            }
        int [] rightmaxarr= new int [W];
        int rightmax = map[W-1];
        for (int i = W-1; i>0; i--)
            {
                rightmax = Math.max(map[i],rightmax);
                rightmaxarr[i] = rightmax;
            }
        int answer =0 ;

        for (int i =1 ; i<W-1; i++)
            {
                int val = Math.min(rightmaxarr[i],leftmaxarr[i]);
                answer = answer + (val-map[i]);
            }
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}