import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int [] Narr = new int[N];

        String [] strarr = br.readLine().split(" ");

        for (int i =0 ; i< N ;i++)
            {
                Narr[i] = Integer.parseInt(strarr[i]);
            }

        Arrays.sort(Narr);

        long answer =0 ;

        if (N ==1 || N ==2)
        {
            bw.write("0");
            bw.close();
            return;
        } 

        for (int i = 0 ; i<N-2 ; i++)
            {
                int needval = 0 - (Narr[i]);

                //여기서 투포인터
                int startindex = i+1;
                int endindex = N-1;
                while (startindex<endindex)
                    {
                        int start = Narr[startindex];
                        int end = Narr[endindex];
                        
                        if(start+end == needval)
                        {
                            if(start == end)
                            {
                                long samecnt = endindex- startindex;
                                answer += (samecnt * (samecnt+1))/2;
                                break;
                            }

                            long startcount = 1;
                            while(startindex+1< endindex && start == Narr[startindex+1] )
                            {
                                startcount +=1; 
                                startindex+=1; 
                            }

                            long endCount = 1;
                            while(startindex < endindex - 1 && Narr[endindex] == Narr[endindex - 1]) {
                                endCount++;
                                endindex--;
                            }

                            answer += (endCount * startcount);
                            startindex+=1;
                            endindex -= 1;
                        }

                        else if (start+end < needval)
                        {
                            startindex +=1;
                        } else {
                            endindex -= 1;
                        }
                    }
                
            }

        bw.write(String.valueOf(answer));
        bw.close();
    
            
        }


}