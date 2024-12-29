import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<List<Integer>> trains = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] oneline = br.readLine().split(" ");
        int N = Integer.parseInt(oneline[0]);
        int M = Integer.parseInt(oneline[1]);

        for (int i = 0 ; i<N ; i++)
            {
                List<Integer> train = new ArrayList<>(
                    Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
                );
                trains.add(train);
            }

        for (int i = 0 ; i<M ; i++)
            {
                String [] twoline = br.readLine().split(" ");
                int job = Integer.parseInt(twoline[0]);
                int who = Integer.parseInt(twoline[1])-1;

                if(job ==1 || job==2)
                {
                    onetwo(job,who,Integer.parseInt(twoline[2])-1);
                } else {
                    threefour(job,who);
                }
            }

        Set<List<Integer>> answerset = new HashSet<>(trains);

        bw.write(String.valueOf(answerset.size()));
        bw.close();

        

    }

    public static void onetwo(int job, int who, int where)
    {
        List<Integer> train = trains.get(who);
        if (job ==1 )
        {
            train.set(where,1);
        } else if (job ==2 )
        {
            train.set(where,0);
        }
    }

    public static void threefour(int job , int who)
    {
        List<Integer> train = trains.get(who);
        if(job ==3 )
        {
            train.add(0,0);
            train.remove(train.size()-1);
        } else if(job ==4)
        {
            train.add(20,0);
            train.remove(0);
        }
    }


    
}