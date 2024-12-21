import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int k; 
    static int [] sarr ;
    static boolean [] visited; 
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        while (true)
            {
                String [] oneline = br.readLine().split(" ");
                k = Integer.parseInt(oneline[0]);
                if(k ==0)
                {
                    break;
                }

                sarr = new int [k];
                for (int i = 0 ; i<k ; i++)
                    {
                        sarr[i] = Integer.parseInt(oneline[i+1]);
                    }
                visited = new boolean[k];

                List<Integer> newlist = new ArrayList<>();
                backtracking(0,0,newlist);
                
                bw.write("\n");
                
            }
        
        bw.close();
        
    }

    public static void backtracking(int start, int depth, List<Integer> setting) throws IOException
    {
        if (depth == 6)
        {
            for (Integer val : setting)
                {
                    bw.write(val+ " ");
                }
            bw.write("\n");
        }

        for (int i = start ; i< k ;i++)
            {
                setting.add(sarr[i]);
                backtracking(i+1, depth+1, setting);
                setting.remove(setting.size()-1);
                
            }
    }

}
