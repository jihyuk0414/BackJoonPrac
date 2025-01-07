    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    // The main method must be in a class named "Main".
    class Main {
        static long [] narr ;
        
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            
            String [] oneline =  br.readLine().split(" ");
            int N = Integer.parseInt(oneline[0]);
            long M = Long.parseLong(oneline[1]);

            narr = new long [N];
            String [] twoline = br.readLine().split(" ");
            for (int j = 0 ; j<N; j++)
                        {
                            narr[j]  =Long.parseLong(twoline[j]);
                        }

            Arrays.sort(narr);

            long start = 0; 
            long end = narr[N-1];
            long answer = 0 ;

            while(start<=end)
                {
                    long mid = (start+end) /2 ; 

                    if (sumcheck(mid) >= M)
                    {
                        answer = Math.max(mid,answer);
                        start = mid+1;
                    } else {
                        end = mid-1;
                    }
                }
            bw.write(String.valueOf(answer));
            bw.close();
            
    
        }

        public static long sumcheck(long cut)
        {
            long cnt = 0 ;
            for (int i = 0 ; i<narr.length; i++)
                {
                    if (cut<= narr[i])
                    {
                        cnt += (narr[i]-cut);
                    }
                }
            return cnt;
            
        }
    
    }