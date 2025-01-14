import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true)
            {
                int N = Integer.parseInt(br.readLine());

                if(N ==0 )
                {
                    break;
                }

                int [] Narr= new int [N];

                for (int i = 0 ; i<N ; i++)
                    {
                        Narr[i] = Integer.parseInt(br.readLine());
                    }

                Arrays.sort(Narr);

                if (Narr[0] != 0 )
                { 
                    bw.write("IMPOSSIBLE"+"\n");
                    continue;
                }

                boolean cango = true;
                
                for (int i = 1 ; i<N ; i++)
                        {
                            if (Narr[i] -Narr[i-1] > 200 )
                            {        
                                cango = false;
                                break;
                            }
                        }

                if (cango)
                {
                    if ((1422-Narr[N-1])*2 >200)
                    {               
                        cango = false;
                    }
                }

                for (int i = N-2; i>=0 ; i--)
                    {
                        if (Narr[i+1] - Narr[i] > 200)
                        {                    
                            cango = false;
                            break;
                        }
                    }

                String answer = cango ? "POSSIBLE" : "IMPOSSIBLE";

                bw.write(answer);
                bw.write("\n");
            }

        bw.close();
        
    }
}