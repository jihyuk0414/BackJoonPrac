import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N ; 
    static int [] Narr ;
    static int answer;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Narr = new int [N];

        String [] oneline = br.readLine().split(" ");
        for (int i =0 ; i<N ; i++)
            {
                Narr[i] = Integer.parseInt(oneline[i]);
            }
        bw.write(String.valueOf(dojob(N, 0 ,N-1)));
        bw.close();
        
    }

    public static int dojob(int N, int start, int end)
    {
        if (start==end)
        {
            return Narr[start];
        }
        
        int mid = (start+end-1)/2;

        int leftanswer = GCD(start,mid) + dojob(N/2,mid+1,end);
        int rightanswer = GCD(mid+1,end) + dojob(N/2,start,mid);

        return Math.max(leftanswer,rightanswer);

    }

    public static int GCD(int start,int end)
    {
        if(start==end)
        {
            return Narr[start];
        }
        
        int startgcd = Narr[start];

        for (int i =start+1; i<=end; i++)
            {
                int a = startgcd;
                int b = Narr[i];
                while(b!=0)
                    {
                        int temp =b ;
                        b = a % b; 
                        a= temp;
                    }
                startgcd =a ;
            }
        return startgcd;
    }
}