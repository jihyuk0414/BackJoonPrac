import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String basic = br.readLine();

        String [] oneline = basic.split("\\-");

        Long answer = 0L ;
        String[]  firstarr = oneline[0].split("\\+");
        for (int i = 0 ; i<firstarr.length;i++)
            {
                answer+= Long.parseLong(firstarr[i]);
            }

        for (int i =1; i<oneline.length;i++)
            {
                String [] twoarr = oneline[i].split("\\+");

                long smallanswer = 0;
                for (int j = 0 ; j<twoarr.length;j++)
                {
                    smallanswer+= Long.parseLong(twoarr[j]);
                }
                answer -= smallanswer;

            }

        bw.write(String.valueOf(answer));
        bw.close();

    }


}