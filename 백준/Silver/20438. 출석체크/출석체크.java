import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] firstline = br.readLine().split(" ");
        int N = Integer.parseInt(firstline[0]);
        int K = Integer.parseInt(firstline[1]);
        int Q =  Integer.parseInt(firstline[2]);
        int M =  Integer.parseInt(firstline[3]);

        String [] twoline = br.readLine().split(" ");

        boolean [] personlist = new boolean[N+3];
        
        List<Integer> sleepingList = new ArrayList<>();

        for (int i = 0 ; i<twoline.length ; i++)
            {
                sleepingList.add(Integer.parseInt(twoline[i]));
            }

        String [] threeline = br.readLine().split(" ");
        List<Integer> startmember = new ArrayList<>();
        for (int i = 0 ; i<threeline.length ; i++)
            {
                startmember.add(Integer.parseInt(threeline[i]));
            }

        for (Integer nowmember : startmember)
            {
                if(sleepingList.contains(nowmember))
                {
                    continue;
                }
                for (int i = nowmember ; i<N+3 ; i+=nowmember)
                    {
                        if (personlist[i])
                        {
                            continue;
                        }
                        if(!sleepingList.contains(i))
                        {
                            personlist[i] = true;
                        }
                    }
            }

        int[] prefix = new int[N + 3];
        
            for(int i = 3; i <= N + 2; i++) {
            prefix[i] = prefix[i-1];
            if(!personlist[i]) {
                prefix[i]++;
            }
        }



        for(int i = 0; i < M; i++) {
            String[] query = br.readLine().split(" ");
            int start = Integer.parseInt(query[0]);
            int end = Integer.parseInt(query[1]);
            bw.write(String.valueOf(prefix[end] - prefix[start-1]));
            bw.newLine();
        }

        bw.close();
    }
}