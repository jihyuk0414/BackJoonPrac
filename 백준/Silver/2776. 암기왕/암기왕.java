import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int x =1 ; x<=T ; x++)
            {
                int N = Integer.parseInt(br.readLine());
                int [] Narr =new int [N];
                String [] Nstr = br.readLine().split(" ");

                for (int i = 0; i<N ;i++)
                    {
                        Narr[i] = Integer.parseInt(Nstr[i]);
                    }
                
                int M = Integer.parseInt(br.readLine());
                int [] Marr =new int [M];
                String [] Mstr = br.readLine().split(" ");

                
                for (int i = 0; i<M ;i++)
                    {
                        Marr[i] = Integer.parseInt(Mstr[i]);
                    }
                Arrays.sort(Narr);
                
                for (int i = 0 ; i<M ; i++)
                    {
                        int start = 0; 
                        int end = N-1;
                        int answer =0 ;
                        
                        while(start<=end)
                        {
                            int mid = (start+end) /2 ;

                            if (Narr[mid] == Marr[i])
                            {
                                answer +=1 ;
                                break;
                            }
                            
                            if(Marr[i] < Narr[mid])
                            {
                                end = mid-1;
                            } else {
                                start = mid +1;
                            }
                        }
                        bw.write(String.valueOf(answer)+ "\n");
                    }
            }

        bw.close();

            
        }


}