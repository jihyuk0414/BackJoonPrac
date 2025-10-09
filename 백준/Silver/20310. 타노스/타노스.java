import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstline = br.readLine();
        StringBuilder sb = new StringBuilder();

        int zerocnt = 0 ;
        int firstcnt = 0;
        int N = firstline.length();

        for (int i = 0 ; i<firstline.length(); i++)
            {
                if (firstline.charAt(i)=='0')
                {
                    zerocnt+=1;
                }else{
                    firstcnt+=1;
                }
            }

        //1은 앞부터
        int idx = 0;
        int firstcut = 0;
        List<Integer> delidx = new ArrayList<>();
        int zerocut = 0;
        while (idx< N)
            {
                if (firstcut < firstcnt/2 && firstline.charAt(idx)=='1')
                {
                    firstcut+=1;
                    delidx.add(idx);
                }

                if (zerocut < zerocnt/2 && firstline.charAt(N-idx-1)=='0')
                {
                    zerocut+=1;
                    delidx.add(N-idx-1);
                }
                    idx +=1;
            }

        for (int i =0 ; i<N; i++)
            {
                if (!delidx.contains(i))
                {
                    sb.append(firstline.charAt(i));
                }
            }
        

        bw.write(sb.toString());
        bw.close();
    }
}