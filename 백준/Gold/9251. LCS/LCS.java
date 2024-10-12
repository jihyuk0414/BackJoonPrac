import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String astr = br.readLine();
        char [] aarr = new char[astr.length()];
        for (int i = 0 ; i<astr.length(); i++)
            {
                aarr[i] = astr.charAt(i);
            }

        String bstr = br.readLine();
        char [] barr = new char[bstr.length()];
        for (int i = 0 ; i<bstr.length(); i++)
            {
                barr[i] = bstr.charAt(i);
            }
        int [][] dp = new int [aarr.length+1][barr.length+1];

        for (int i = 1; i<=aarr.length ; i++)
            {

                for (int j = 1; j<=barr.length; j++)
                    {
                        if (aarr[i-1] == barr[j-1]) 
                        {
                            dp[i][j] = dp[i-1][j-1]+1; 
                        }

                        else 
                        {
                            dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                        }
                        
                    }
            }

        int answer = dp[astr.length()][bstr.length()];
        
        bw.write(String.valueOf(answer));
        bw.close();
    }
}