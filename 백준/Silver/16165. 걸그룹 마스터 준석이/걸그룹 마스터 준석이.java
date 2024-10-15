import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputstr = br.readLine().split(" ");
        int N= Integer.parseInt(inputstr[0]);
        int M = Integer.parseInt(inputstr[1]);

        Map<String, List<String>> teammap = new LinkedHashMap<>();
         Map<String, String> memberToTeam = new HashMap<>();
        
        for (int i = 0 ; i<N ; i++)
            {
                String teamname = br.readLine();

                int memberlength = Integer.parseInt(br.readLine());
                List<String> members = new ArrayList<>();

                for (int j = 0 ; j<memberlength; j++)
                    {
                        String membername= br.readLine();
                        members.add(membername);
                         memberToTeam.put(membername, teamname);
                    }
                teammap.put(teamname,members);
            }

        StringBuilder answer = new StringBuilder();

        //숫자
        for (int i = 0 ; i <M ; i++)
            {
                String findname = br.readLine();
                int quiz = Integer.parseInt(br.readLine());

                if (quiz == 0)
                {
                    List<String> members = teammap.get(findname);
                    Collections.sort(members);
                    for (String member : members) {
                    answer.append(member).append("\n");
                    }
                }

                else{
                    answer.append(memberToTeam.get(findname)+"\n");
                }
            }

        bw.write(answer.toString());
        bw.close();
    }
}