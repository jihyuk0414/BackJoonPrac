import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T= Integer.parseInt(br.readLine()); 

        for (int i = 0 ; i<T; i++)
            {
                String [] firstline = br.readLine().split(" ");
                int n = Integer.parseInt(firstline[0]);
                int d = Integer.parseInt(firstline[1]); 

                int [][] narr = new int [n][n];
                for (int j = 0 ; j<n ;j++)
                    {
                        String [] onearr = br.readLine().split(" ");
                        for (int x = 0 ; x<n ; x++)
                            {
                                narr[j][x] = Integer.parseInt(onearr[x]);
                            }
                    }
                //배열 만들기 성공

                //대각 확인
                

                if (d>=0)
                {
                    for (int howlong = 0 ; howlong<(d/45) ; howlong++)
                        {

                            int [] zoodagak = new int[n];
                for (int z = 0; z<n ; z++)
                        {
                            zoodagak[z]=narr[z][z];
                        }
                int [] sero = new int[n];
                for (int z = 0; z<n ; z++)
                {
                        sero[z]=narr[z][n/2];
                }
                int [] garo = new int [n];
                for (int z = 0; z<n ; z++)
                                    {
                                    garo[z]=narr[n/2][z];
                                }
                int [] yukdagak = new int[n];
                for (int z = 0; z<n ; z++)
                                {
                                    yukdagak[z]=narr[z][n-z-1];
                                }
                            
                            for (int z = 0 ; z<n; z++)
                                {
                                    //주대각은 세로로
                                    narr[z][n/2] = zoodagak[z];

                                    //세로는 역대각
                                    narr[z][n-z-1] = sero[z];

                                    //가로는 역대각으로
                                    narr[n/2][n-z-1] = yukdagak[z];

                                    //역대각은 가로로
                                    narr[z][z] = garo[z];

                                    
                                }  
                        }
                } else{
                    for (int howlong = 0 ; howlong<(Math.abs(d)/45) ; howlong++)
                        {

                            int [] zoodagak = new int[n];
                for (int z = 0; z<n ; z++)
                        {
                            zoodagak[z]=narr[z][z];
                        }
                int [] sero = new int[n];
                for (int z = 0; z<n ; z++)
                {
                        sero[z]=narr[z][n/2];
                }
                int [] garo = new int [n];
                for (int z = 0; z<n ; z++)
                                    {
                                    garo[z]=narr[n/2][z];
                                }
                int [] yukdagak = new int[n];
                for (int z = 0; z<n ; z++)
                                {
                                    yukdagak[z]=narr[z][n-z-1];
                                }
                            
                            for (int z = 0 ; z<n; z++)
                                {
                                    //주대각은 가로로
                                    narr[n/2][z] = zoodagak[z];

                                    //세로는 역대각
                                    narr[z][z] = sero[z];

                                    //역대각은 가로로
                                    narr[z][n-z-1] = garo[n-z-1];

                                    //가로는 역대각으로
                                    narr[z][n/2] = yukdagak[z];
                                }  
                        }
                }
                for (int prx= 0 ; prx<n; prx++)
                    {
                        for (int pry= 0 ; pry<n; pry++)
                            {
                                bw.write(narr[prx][pry]+" ");
                            }
                        bw.write("\n");
                    }
            }
        
        bw.close();
        
    }
}
