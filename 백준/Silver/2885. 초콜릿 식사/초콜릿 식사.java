import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if(N == 1)
        {
            bw.write("1, 0");
            bw.close();
            return;
        }

        int nfind = N;
        int nval = 0;
        boolean nleft = false;

        while(nfind>1)
            {
                if (nfind % 2 != 0)
                {
                    nleft = true;
                }
                nfind /= 2;
                nval +=1; 
            }

        int simillarn = nleft? (int) Math.pow(2,nval+1) : (int)Math.pow(2, nval);
        int answersimillarn = simillarn;

        int answer = 0;
        
        while (simillarn > 0)
            {
                if (simillarn == N)
                {
                    N = N- simillarn;
                    break;
                }else if (N > simillarn)
                {
                    N = N -simillarn;
                    continue;
                } else if (N < simillarn)
                {
                    simillarn /= 2;
                    answer +=1;
                }
            }

        bw.write(answersimillarn+" " + answer);
        
        bw.close();
        
    }
}