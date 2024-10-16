import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String nstr = br.readLine();
        char[] narr = new char[nstr.length()];

        for (int i = 0 ; i<nstr.length(); i++)
            {
                narr[i] = nstr.charAt(i);
            }

        Set<String> myset = new HashSet<>();

        for (int i = 0 ; i< narr.length; i++)
            {
                String addstr = "";
                for (int j = i ; j< narr.length; j++)
                    {
                        addstr+= narr[j];
                        myset.add(addstr);
                    }
            }

        bw.write(String.valueOf(myset.size()));
        bw.close();
    }
}