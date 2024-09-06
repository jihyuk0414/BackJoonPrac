import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

        static int N;
        static int [] Nlist;
        static HashSet<Integer> answerset;
        static boolean [] visited ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Nlist = new int[N+1];

        for (int i =1; i<N+1 ; i++)
            {
                Nlist[i] = Integer.parseInt(br.readLine());
            }

        answerset = new HashSet<>();

        for (int i = 1; i <N+1; i++)
            {
                visited= new boolean[N+1]; 
                HashSet<Integer> startset = new HashSet<>();  // Set 초기화
                HashSet<Integer> endset = new HashSet<>();
                DFS(i,startset,endset);
            }

        List<Integer> answerlist = new ArrayList<>(answerset);
        Collections.sort(answerlist);

        bw.write(answerlist.size() + "\n");
        for (int ans : answerlist)
            {
                bw.write(ans + "\n");
            }
        bw.flush();
        bw.close();
        
    }

    public static void DFS(int nowindex, HashSet startset, HashSet endset)
    {
        if (visited[nowindex] == false)
        {
            visited[nowindex] = true;
            int nextindex = Nlist[nowindex];

            startset.add(nowindex);
            endset.add(nextindex);

            if(startset.equals(endset))
            {
                answerset.addAll(startset);
                return;
            }

            DFS(nextindex,startset,endset) ;
            
        }
    }
}