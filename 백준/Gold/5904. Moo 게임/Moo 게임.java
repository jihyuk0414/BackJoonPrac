import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        long whatmoo = 0 ;
        long beforelen = 3;

        while(N > beforelen)
            {
                whatmoo+=1;
                beforelen = beforelen*2 + (whatmoo+3);
            }

        bw.write(moo(N,whatmoo));
        bw.close();
        
    }

    public static char moo(long N, long whatmoo)
    {
        if(whatmoo == 0 )
        {
            return N==1 ? 'm' : 'o';
        }

        long beforelen = getBeforelength(whatmoo-1);

        //처음 곳이라면
        if(N<= beforelen)
        {
            return moo(N, whatmoo-1);
        } else if (beforelen< N && N <= beforelen+whatmoo+3){
            return (N-beforelen) ==1 ? 'm' : 'o';
        } else{
            return moo(N-(beforelen+whatmoo+3), whatmoo-1);
        }
    }

    public static long getBeforelength(long depth)
    {
        if (depth == 0 )
        {
            return 3;
        } else{
            return (2*getBeforelength(depth-1) + depth+3) ;
        }
    }
}