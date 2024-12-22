import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N ;
    static char [] map ;
    static boolean [] visited;
    static List<String> answerlist = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        String [] oneline = br.readLine().split(" ");

        map = new char[N];

        for (int i = 0 ; i<N ; i++)
            {
                map[i] = oneline[i].charAt(0);
            }

        visited = new boolean[10];
        StringBuilder sb = new StringBuilder();
        dfs(0,sb);

        Collections.sort(answerlist);
        bw.write(answerlist.get(answerlist.size()-1));
        bw.write("\n");
        
        bw.write(answerlist.get(0));
        

        bw.close();

       
    }


    public static void dfs(int depth, StringBuilder sb)
    {

        if (depth == N+1)
        {
            answerlist.add(sb.toString());
            return;
        }

        if (depth == 0)
        {
            for (int i =0  ; i<=9 ; i++)
                {
                    visited[i] = true;
                    sb.append(String.valueOf(i));
                    dfs(depth+1,sb);
                    sb.deleteCharAt(sb.length()-1);
                    visited[i] = false;
                }
            return ;
        }
        

        char nowchar = map[depth-1];
        int beforenum = Character.getNumericValue(sb.toString().charAt(sb.length()-1));

        if (nowchar == '<')
        {
            for (int i = 0 ; i<=9 ; i++)
                {
                    if (!visited[i] && beforenum<i)
                    {
                        visited[i] = true;
                        sb.append(String.valueOf(i));
                        dfs(depth+1,sb);
                        sb.deleteCharAt(sb.length()-1);
                        visited[i] = false;
                    }
                }
        } else {
            for (int i = 0 ; i<=9 ; i++)
                {
                    if (!visited[i] && beforenum>i)
                    {
                        visited[i] = true;
                        sb.append(String.valueOf(i));
                        dfs(depth+1,sb);
                        sb.deleteCharAt(sb.length()-1);
                        visited[i] = false;
                    }
                }
        }

        

        
    }

    
}