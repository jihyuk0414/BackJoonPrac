import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long val = Long.parseLong(br.readLine());
        String nowstr = makenum(val);
        bw.write(nowstr);
        
        bw.close();
    }

    public static String makenum (long originnum)
    {
        StringBuilder sb = new StringBuilder();
        originnum -= 1; 
        if (originnum == 0 )
        {
            return "4";
        }
        while (originnum>=0)
            {
                if (originnum%2 == 0)
                {
                    sb.append("4") ; 
                } else {
                    sb.append("7");
                }
                originnum = (originnum/2)-1;
            }
        return sb.reverse().toString();
    }
}
