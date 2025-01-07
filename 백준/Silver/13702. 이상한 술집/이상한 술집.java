    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    // The main method must be in a class named "Main".
    class Main {
        static int [] narr ;
        
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            
            String [] oneline =  br.readLine().split(" ");
            int N = Integer.parseInt(oneline[0]);
            int K = Integer.parseInt(oneline[1]);

            narr = new int[N] ;
            
            for (int i = 0 ; i<N; i++)
                {
                    narr[i] = Integer.parseInt(br.readLine());
                }

            Arrays.sort(narr);

            int start = 1 ;
            int end = narr[N-1];
            int answer= 0 ;
            

            while(start<=end)
                {
                    int mid = start + (end - start)/2;

                    if (check(mid) >= K)
                    {
                        start = mid+1;
                        answer = Math.max(answer,mid);
                    } else {
                        end = mid-1;
                    }
                }

            bw.write(String.valueOf(answer));
            bw.close();
    
        }

        public static int check (int cut)
        {
            int cnt = 0;
            for (int i = 0 ; i<narr.length; i++)
                {
                    if (narr[i] == 0  || cut == 0)
                    {
                        continue;
                    }
                    cnt += (narr[i]/cut);
                }
            return cnt;
            
        }
    
    }