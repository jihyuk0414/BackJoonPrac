import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String oneline = br.readLine();
        StringBuilder sb= new StringBuilder();
        int end = oneline.length()-1;
        int answer = -1;

        while(end >=0)
            {
                sb.append(oneline.charAt(end));

                //검사
                String nowsb= oneline.substring(end,oneline.length());
                StringBuilder reversesb = new StringBuilder(nowsb);
                reversesb.reverse();

                if(nowsb.equals(reversesb.toString()))
                {
                    answer = end;
                }

                end -=1 ;
            }

        if (answer ==0 )
        {
            bw.write(oneline.length()+ " ");
            bw.close();
            return;
        }

        if(answer == oneline.length()-1)
        {
            bw.write(String.valueOf((oneline.length()-1)*2+1));
            bw.close();
        } else{
            bw.write(String.valueOf(Math.min(answer*2+(oneline.length()-answer),(oneline.length()-1)*2+1)));
            bw.close();
        } 
    }
}