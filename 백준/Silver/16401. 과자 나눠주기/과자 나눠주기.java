import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline =br.readLine().split(" ");
        int N = Integer.parseInt(oneline[1]);
        int M = Integer.parseInt(oneline[0]);

        int answer = 0;
        String [] twoline = br.readLine().split(" ");
        List<Integer> mlist  = new ArrayList<>();

        for (int i = 0 ; i<N; i++)
            {
                mlist.add(Integer.parseInt(twoline[i]));
            }

        Collections.sort(mlist);

        int start = 1;
        int end = mlist.get(mlist.size()-1);

        boolean globalcnt = false;
        while(start <= end)
            {
                int findcnt = 0;
                int mid = start+(end-start)/2;
                for (int i = 0 ; i<N; i++)
                    {
                        if (mlist.get(i) >= mid)
                        {
                            if(mlist.get(i) == 0)
                            {
                                continue;
                            }
                            findcnt = findcnt + (mlist.get(i)/mid);
                        }
                    }
                
                if(findcnt >= M)
                {
                    globalcnt = true;
                    start = mid+1;
                    answer = mid;
                }
                else
                {
                    end = mid-1;
                }
            }

        if (globalcnt == false)
        {
            answer = 0 ;
        }

        bw.write(String.valueOf(answer));
        bw.close();

        
    }

}