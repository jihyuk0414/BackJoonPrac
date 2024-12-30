import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2= br.readLine();

        int [][] dp = new int [str1.length()+1][str2.length()+1];

        for(int i=1 ; i<=str1.length() ; i++)
            {
                for (int j =1 ; j<=str2.length(); j++)
                    {
                        int x= i-1;
                        int y= j-1;
                        if(str1.charAt(x) == str2.charAt(y))
                        {
                            dp[i][j] = dp[i-1][j-1]+1; //하나전꺼에서 지금배열 추가
                        } else{
                            dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                        }
                    }
            }

        StringBuilder reverseanswer = new StringBuilder();
        int xpointer = str1.length();
        int ypointer = str2.length();
        while(xpointer> 0 && ypointer>0)
            {
                if(str1.charAt(xpointer-1) == str2.charAt(ypointer-1))
                {
                    reverseanswer.append(str1.charAt(xpointer-1));
                    xpointer-=1;
                    ypointer-=1;
                }
                else if (dp[xpointer-1][ypointer]>=dp[xpointer][ypointer-1])
                    {
                        xpointer-=1;
                    } 
                else{
                        ypointer-=1;
                    }
            }

        
        bw.write(dp[str1.length()][str2.length()]+"\n");
        if(dp[str1.length()][str2.length()] !=0)
        {
            bw.write(reverseanswer.reverse().toString());
        }

        bw.close();
    }
}