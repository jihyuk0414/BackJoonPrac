import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int x = 0 ; x<T ; x++)
            {
                String [] oneline = br.readLine().split(" ");
                int N = Integer.parseInt(oneline[0]);
                int M = Integer.parseInt(oneline[1]);

                int [][] arr = new int[N+1][N+1];

                for (int i = 1 ; i <= N ; i++)
                    {
                        String [] arrline = br.readLine().split(" ");
                        for (int j = 0; j<N ; j++ )
                            {
                                arr[i][j+1] = Integer.parseInt(arrline[j]);
                            }
                    }

                int [] Narr = new int[N+1]; //행 
                int [] Marr = new int[N+1]; // 열

                for (int i = 1 ; i<= N ; i++)
                    {
                        int nsum = 0 ;
                        for (int j =1 ; j<=N ; j++)
                            {
                                nsum += arr[i][j];
                            }
                        Narr[i] = nsum;
                    }

                for (int i = 1 ; i<= N ; i++)
                    {
                        int msum = 0 ;
                        for (int j =1 ; j<=N ; j++)
                            {
                                msum += arr[j][i];
                            }
                        Marr[i] = msum;
                    }

                //m개의 도전
                for (int i = 0 ; i<M ; i++)
                    {
                        String [] mline = br.readLine().split(" ");
                        int r1 = Integer.parseInt(mline[0]);
                        int c1 = Integer.parseInt(mline[1]);
                        int r2 = Integer.parseInt(mline[2]);
                        int c2 = Integer.parseInt(mline[3]);
                        int v = Integer.parseInt(mline[4]);

                        //행
                        for (int j = r1; j<=r2 ; j++)
                            {
                                Narr[j] += (c2-c1+1)*v;
                            }

                        //열
                        for (int j = c1; j<=c2 ; j++)
                            {
                                Marr[j] += (r2-r1+1)*v;
                            }

                        
                    }

                
                for (int i = 1 ; i<= N ; i++)
                    {
                        bw.write(String.valueOf(Narr[i]) + " ");
                    }
                bw.write("\n");

                
                for (int i = 1 ; i<= N ; i++)
                    {
                        bw.write(String.valueOf(Marr[i]) + " ");
                    }
                if (x != (T-1))
                {
                    
                    bw.write("\n");
                }

                
            }


        bw.close();

        
    }
}