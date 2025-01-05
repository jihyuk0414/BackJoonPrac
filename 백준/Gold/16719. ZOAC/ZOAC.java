import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N ; 
    static boolean [] visited;
    static String oneline ;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        oneline = br.readLine();

        visited = new boolean[oneline.length()];
        N = oneline.length();

        dojob(oneline,0,N);

        bw.close();
    }

    public static void dojob(String substring,int start, int end) throws IOException
    {
        if (substring.equals("")) {
            return;
        }
        
        char defaultchar = substring.charAt(0);
        int findindex = 0 ;

        for (int i = 0 ; i<substring.length(); i++)
            {
                if(substring.charAt(i)<defaultchar)
                {
                    defaultchar = substring.charAt(i);
                    findindex = i;
                }
            }

        //실제 index 대비 어디 인가
        for (int i = 0 ; i<N ; i++)
            {
                if (i>= start && i<=end)
                {
                    if (oneline.charAt(i) == defaultchar)
                    {
                        visited[i]= true;
                        break;
                    }
                }
            }

        printgo();

        if(findindex+1 < substring.length() )
        {
            dojob(substring.substring(findindex+1),start+findindex+1,end);
        }

        dojob(substring.substring(0,findindex),start,start+findindex);

        
    }

    public static void printgo() throws IOException{
        for (int i = 0 ; i<N ; i++)
            {
                if (visited[i])
                {
                    bw.write(oneline.charAt(i));
                }
            }
        bw.write("\n");
    }

}