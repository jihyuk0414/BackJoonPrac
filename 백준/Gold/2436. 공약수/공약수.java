import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static long gcd (long a, long b)
    {
        while (b>0)
            {
                long c = b;
                b = a%b;
                a = c;
            }
        return a;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");
        long gongyak = Long.parseLong(oneline[0]);
        long gongbae = Long.parseLong(oneline[1]);

        long ab = gongbae/gongyak;

        //이제 ab에서 가능한 a, b 쌍을 모두 구한다. 

        long minval = Long.MAX_VALUE;
        long mina = 0;
        long minb = 0;
        
        for (long i = 1; i<=Math.sqrt(ab) ; i++)
            {
                if (ab%i ==0 )
                {
                    long a = i;
                    long b = ab/i ; 

                    if (gcd(a,b) == 1 && Math.abs(b-a) < minval)
                    {
                        minval = Math.abs(b-a);
                        mina = a ;
                        minb = b;
                    }
                }
            }

        if (mina < minb)
        {
            bw.write(mina*gongyak +" "+ minb*gongyak);
        }else {
            bw.write(minb*gongyak+" "+ mina*gongyak);
        }
        bw.close();
    }

}