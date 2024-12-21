import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int l ;
    static int c ;
    static char[] carr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Character> moeum = Arrays.asList('a','e','i','o','u');

    public static void main(String[] args) throws IOException {

        String [] oneline = br.readLine().split(" ");
        l = Integer.parseInt(oneline[0]);
        c = Integer.parseInt(oneline[1]);
        carr = new char[c];
        String [] twoline = br.readLine().split(" ");
        for (int i = 0 ; i<c ; i++ )
            {
                carr[i] = twoline[i].charAt(0);
            }
        Arrays.sort(carr);

        StringBuilder sb  = new StringBuilder();
        backtracking(0,0,sb);
        bw.close();
        
    }

    public static void backtracking(int beforeindex, int depth, StringBuilder sb) throws IOException
    {
        if (depth == l)
        {
            String nowstring = sb.toString();
            int moeumcnt = 0;
            for (int i = 0 ; i<nowstring.length(); i++)
                {
                    if(moeum.contains(nowstring.charAt(i)))
                    {
                        moeumcnt+=1;
                    }
                }
            if(moeumcnt>=1 && ((nowstring.length()-moeumcnt)>=2))
            {
                bw.write(nowstring);
                bw.write("\n");
            }
        }

        for (int i = beforeindex; i<c ; i++)
            {
                sb.append(carr[i]);
                backtracking(i+1,depth+1,sb);
                sb.deleteCharAt(sb.length() - 1);
            }
    }

}
