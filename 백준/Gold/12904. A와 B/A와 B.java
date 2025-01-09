import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String T = br.readLine();

        List<Character> Slist = new ArrayList<>();

        List<Character> Tlist = new ArrayList<>();

        for (int i = 0 ; i< S.length() ; i++)
            {
                Slist.add(S.charAt(i));
            }

        
        for (int i = 0 ; i< T.length() ; i++)
            {
                Tlist.add(T.charAt(i));
            }
        
        while(Tlist.size() > Slist.size())
            {
                if(Tlist.get(Tlist.size()-1) == 'A')
                {
                    Tlist.remove(Tlist.size()-1);
                } else if (Tlist.get(Tlist.size()-1) == 'B')
                {
                    Tlist.remove(Tlist.size()-1);
                    Collections.reverse(Tlist);
                }
            }

        boolean ok = false;

        if(Tlist.size() == Slist.size())
        {
            String compareT = "";
            String compareS = "" ;

            for (int i = 0 ; i<Tlist.size(); i++)
                {
                    compareT += Tlist.get(i);
                    compareS += Slist.get(i);
                }

            if(compareT.equals(compareS))
            {
                ok = true;
            }
        }

        String answer = ok ? "1" : "0";
        bw.write(answer);
        bw.close();

        
    }
}