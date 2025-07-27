import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int K = Integer.parseInt(oneline[1]);
        int answer = 0 ;

        int [][] Narr = new int [N][3];
        for (int i = 0 ; i<N; i++)
            {
                String [] twoline = br.readLine().split(" ");
                for (int j = 0 ; j <twoline.length; j++)
                    {
                        Narr[i][j] = Integer.parseInt(twoline[j]);
                    }
            }

        int [][] plusarr = new int [N][3];

        for (int i = 0 ; i<N;  i++)
            {
                int [] now = Narr[i];
                plusarr[i][0] = now[0]+now[1];
                plusarr[i][1] = now[0]+now[2];
                plusarr[i][2] = now[2]+now[1];
            }

        Arrays.sort(plusarr, (a,b) -> {
            return b[0]-a[0];
        });

        int localans = 0 ;
        for (int i = 0 ; i<K ; i++)
            {
                localans += plusarr[i][0];
            }
        answer = Math.max(localans,answer);

        
        Arrays.sort(plusarr, (a,b) -> {
            return b[1]-a[1];
        });

        localans = 0 ;
        for (int i = 0 ; i<K ; i++)
            {
                localans += plusarr[i][1];
            }
        answer = Math.max(localans,answer);
        
        Arrays.sort(plusarr, (a,b) -> {
            return b[2]-a[2];
        });

        localans = 0 ;
        for (int i = 0 ; i<K ; i++)
            {
                localans += plusarr[i][2];
            }
        answer = Math.max(localans,answer);

        bw.write(String.valueOf(answer));
        bw.close();

    }
}