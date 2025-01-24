import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] Narr =new int [N];
        String [] oneline =br.readLine().split(" ");

        for (int i = 0 ; i<N ; i++)
            {
                Narr[i] = Integer.parseInt(oneline[i]);
            }

        int [] needval = new int [1000001];
        int arrow = 0;

        for (int i = 0; i<N ; i++)
            {
                int nowval = Narr[i];

                if (needval[nowval] > 0 )
                {
                    needval[nowval] -= 1 ;
                    needval[--nowval] += 1;
                } else {
                    arrow+=1;
                    needval[--nowval] +=1;
                }
            }
        
        bw.write(arrow+"");
        bw.close();
    
    }

}