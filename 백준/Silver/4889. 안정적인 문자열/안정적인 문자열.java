import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int whereyouat = 1;

        while (true)
            {
                String oneline = br.readLine();

                boolean realbreak = false;
                for (int i = 0 ; i<oneline.length() ; i++)
                    {
                        Character nowchar = oneline.charAt(i);

                        if(nowchar == '-')
                        {
                            realbreak = true;
                            break;
                        }
                    }
                if(realbreak)
                {
                    break;
                }

                Stack<Character> checkstack = new Stack<>();
                
                int leftcheck = 0 ;

                for (int i = 0 ; i<oneline.length() ; i++)
                    {
                        Character nowchar = oneline.charAt(i);

                        if(nowchar == '{')
                        {
                            checkstack.push(nowchar);
                        } else {
                            if(checkstack.isEmpty())
                            {
                                leftcheck +=1;
                                checkstack.push('{');
                            } else {
                                checkstack.pop();
                            }
                        }
                    }
                
                bw.write(whereyouat+". "+ (leftcheck+checkstack.size()/2)+"\n");
                whereyouat+=1;
                
            }
        bw.close();
        
    }
}