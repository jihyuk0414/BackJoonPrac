import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String [] Strarr = br.readLine().split(" ");
        int[] Narr = new int[N];
        int sumNarr = 0 ;
        for(int i =0; i<N; i++)
            {
                Narr[i] = Integer.parseInt(Strarr[i]);
                sumNarr+=Narr[i];    
            }
        Arrays.sort(Narr);
        int M = Integer.parseInt(br.readLine());

        if(sumNarr<M)
        {
            bw.write(String.valueOf(Narr[N-1]));
            bw.flush();
            bw.close();
        }

        else{
            int start = 0 ;
            int end = Narr[N-1];
            int result = 0 ;
            int sumcnt = 0 ;

            while(start<=end)
                {
                    int mid = (start+end)/2;
                    sumcnt = 0;
                    //탐색 범위 설정
                    for(int val: Narr) 
                        {
                            if(val<mid)
                            {
                                sumcnt+=val;
                            } else{
                                sumcnt+=mid;
                            }
                        }

                    if (sumcnt>M) //판별에 따른 탐색 범위 설정                        
                    {
                        end =mid-1; 
                    } else {
                        result = mid;
                        start = mid +1;
                    }
                }

            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
            
        }
        

    }
    
}