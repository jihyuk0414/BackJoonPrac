import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");
        int R = Integer.parseInt(oneline[0]);
        int C = Integer.parseInt(oneline[1]);
        
        Character [][] map = new Character[R][C];

        for (int i = 0 ;i<R ; i++)
            {
                String twoline = br.readLine();
                for (int j = 0 ; j<C ; j++)
                    {
                        map[i][j] = twoline.charAt(j);
                    }
            }

        List<String> answerlist = new ArrayList<>();

        //가로부터 체크
        for (int i = 0 ; i<R ; i++)
            {
                String totalstring = "";
                for (int j = 0 ; j<C ;j++)
                    {
                        char nowval = map[i][j];
                        if(nowval =='#')
                        {
                            continue;
                        }

                        totalstring += nowval;
                        //검사
                        if(j+1 == C || map[i][j+1] == '#')
                        {
                            if(totalstring.length()==1)
                            {
                                totalstring = "";
                                continue;
                            }
                            answerlist.add(totalstring);
                            totalstring = "";
                        }
                    }
            }

        //세로 체크
        for (int j = 0 ; j<C ; j++)
            {
                String totalstring = "";
                for (int i = 0 ; i<R ; i++)
                    {
                        char nowval = map[i][j];
                        if(nowval =='#')
                        {
                            continue;
                        }

                        totalstring += nowval;
                        //검사
                        if(i+1 == R || map[i+1][j] == '#')
                        {
                            if(totalstring.length()==1)
                            {
                                totalstring = "";
                                continue;
                            }
                            answerlist.add(totalstring);
                            totalstring = "";
                        }
                    }
            }

        Collections.sort(answerlist);

        bw.write(answerlist.get(0));
        bw.close();



        
    }
}