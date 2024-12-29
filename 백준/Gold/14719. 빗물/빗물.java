import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int R ; 
    static int C;
    static char [] [] map ;
    static boolean[][] visited ;
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int answer = 1;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] oneline = br.readLine().split(" ");
        int H = Integer.parseInt(oneline[0]);
        int W = Integer.parseInt(oneline[1]);

        int [] height =new int [W];
        String [] twoline = br.readLine().split(" ");
        for (int i =0 ; i<W ; i++)
            {
                height[i] = Integer.parseInt(twoline[i]);
            }

        int answer = 0 ;
        
        for (int i = 1 ; i<W-1 ;i++)
            {
                int leftmax = 0 ;
                int rightmax = 0 ;

                for (int j = 0; j<i; j++)
                    {
                        leftmax = Math.max(height[j],leftmax);
                    }
                for (int j = i+1; j<W; j++)
                    {
                        rightmax = Math.max(height[j],rightmax);
                    }

                if(height[i]<leftmax && height[i]<rightmax)
                {
                    answer+= (Math.min(leftmax,rightmax)-height[i]);
                }
                
                
            }
        bw.write(answer+"");
        bw.close();
    }

 
    
}