import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<String> nlist = new ArrayList<>();

        for (int i = 0 ; i<N ; i++)
            {
                nlist.add(br.readLine());
            }

        Collections.sort(nlist, (a,b) -> {
            if (a.length() ==  b.length())
            {
                int asum = 0 ;
                for (int i = 0; i<a.length() ; i++)
                    {
                        if(Character.isDigit(a.charAt(i)))
                        {
                            asum+= Character.getNumericValue(a.charAt(i));
                        }
                    }

                int bsum = 0 ;
                for (int i = 0 ; i<b.length() ; i++)
                    {
                        if(Character.isDigit(b.charAt(i)))
                        {
                            bsum += Character.getNumericValue(b.charAt(i));
                        }
                    }

                if(bsum == asum)
                {
                    return a.compareTo(b);
                } else{
                    return asum-bsum;
                }
            } else{
                return a.length()-b.length();
            }
        });

        for (String s : nlist) {
            bw.write(s);
            bw.newLine();
        }

        bw.close();
    }
}