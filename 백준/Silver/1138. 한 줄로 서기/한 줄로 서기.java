import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int [] answerarr ;
    
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();
       int N = Integer.parseInt(br.readLine());

       int [] Narr = new int [N];

        answerarr = new int [N];
       String [] oneline =br.readLine().split(" ");
       for (int i = 0 ; i<N ; i++)
           {
               Narr[i]  =Integer.parseInt(oneline[i]);
           }

        int [] testarr = new int[N];
        answerarr(0,Narr,testarr);

        for (int i = 0 ; i<answerarr.length; i++)
            {
                bw.write(answerarr[i]+" ");
            }
        bw.close();
   }

    public static void answerarr(int idx, int [] Narr, int [] testarr)
    {
        if (idx == Narr.length)
        {
            if (check(Narr,testarr))
            {
                for (int i = 0 ; i< answerarr.length; i++)
                    {
                        answerarr[i] = testarr[i];
                    }
            }
            return;
        }

        for (int i = 0 ; i< testarr.length; i++)
            {
                if(testarr[i] != 0)
                {
                    continue;
                }
                testarr[i] = idx+1;
                answerarr(idx+1,Narr,testarr);
                testarr[i] = 0;
            }
        return;
    }

    public static boolean check (int [] Narr, int [] testarr)
    {
        for (int i = 0; i < testarr.length; i++) {
            if (testarr[i] == 0) {
                return false;
            }
        }
        
        for (int i = 0 ; i<testarr.length; i++)
            {   
                int heightidx = -1;
                for (int j = 0 ; j<testarr.length; j++)
                    {
                        if (testarr[j] == i+1)
                        {
                            heightidx = j ; 
                            break;
                        }
                    }

                int cnt = 0 ;
                for (int j = 0 ;j<heightidx ; j++)
                    {
                        if (testarr[j] > i+1)
                        {
                            cnt +=1;
                        }
                    }
                if (cnt != Narr[i])
                {
                    return false;
                }
            }

        return true;
    }
}