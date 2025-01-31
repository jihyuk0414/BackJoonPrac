import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N;
    static int [][] Narr ;
    static boolean[] broken ;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N= Integer.parseInt(br.readLine());
        Narr = new int[N][2]; //내구도, 무게
        broken = new boolean[N];

        for (int i = 0 ;i<N; i++)
            {
                String [] oneline = br.readLine().split(" ");
                Narr[i][0] = Integer.parseInt(oneline[0]);
                Narr[i][1] = Integer.parseInt(oneline[1]);
            }

        backtacking(0);

        bw.write(answer+"");
        bw.close();
    }

    public static void backtacking(int lefthandegg)
    {
        answer=Math.max(answer,findbroken());
        //가장 최근
        if (lefthandegg == N)
        {
            return;
        }

        if (broken[lefthandegg])
        {
            backtacking(lefthandegg+1);
            return;
        }

            boolean canHit = false;
    for (int i = 0; i < N; i++) {
        if (i != lefthandegg && !broken[i]) {
            canHit = true;
            break;
        }
    }
    if (!canHit) {
        answer = Math.max(answer, findbroken());
        return;
    }

        for (int i = 0 ; i<N; i++)
            {
                if ( i!= lefthandegg && !broken[i])
                {
                    int leftweight = Narr[lefthandegg][1];
                    int rightweight = Narr[i][1];
                    
                    Narr[lefthandegg][0] -= rightweight;
                    Narr[i][0] -= leftweight;

                    if (Narr[lefthandegg][0] <=0 )
                    {
                        broken[lefthandegg] = true;
                    } 
                    
                    if (Narr[i][0] <=0 )
                    {
                        broken[i] = true;
                    } 
                    
                    backtacking(lefthandegg+1);

                    broken[lefthandegg] = false;
                    broken[i] = false;
                    Narr[lefthandegg][0] += rightweight;
                    Narr[i][0] += leftweight;
                }
            }

        
    }

    public static int findbroken()
    {
        int brokencnt = 0;
        for (int i = 0 ; i<N; i++)
            {
                if (broken[i])
                {
                    brokencnt+=1;
                }
            }
        return brokencnt;
    }
}