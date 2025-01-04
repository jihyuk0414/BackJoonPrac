import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<String> q = new ArrayDeque<>();

        for (int i = 0 ; i<N ; i++)
            {
                q.add(br.readLine());
            }

        String [] bstr = new String[N];
        for (int i = 0 ; i<N ; i++)
            {
                bstr[i] = br.readLine();
            }

        int answer= 0;

        for (int i = 0 ; i<N ; i++)
            {
                String nowval  =bstr[i];

                if(q.peek().equals(nowval))
                {
                    q.poll();
                    continue;
                }else{
                    answer +=1;
                    List<String> savelist = new ArrayList<>();
                    
                    while (true)
                        {
                            if (q.peek().equals(nowval))
                            {
                                q.poll();
                                break;
                            }

                            String val = q.poll();
                            savelist.add(val);                            
                        }

                    for (int j = savelist.size()-1 ; j>=0 ; j--)
                        {
                            q.addFirst(savelist.get(j));
                        }
                }
            }

        bw.write(String.valueOf(answer));
        bw.close();
    }
}