import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] firstline = br.readLine().split(" ");
        int N = Integer.parseInt(firstline[0]);
        int M = Integer.parseInt(firstline[1]);

        Set<Integer> whoknowtruth = new HashSet<>();
        boolean [] canlieparty = new boolean[M]; //false 수가 답임

        String [] secondline = br.readLine().split(" ");

        int truthPeople = Integer.parseInt(secondline[0]);
        if (truthPeople == 0) {
            bw.write(String.valueOf(M));
            bw.flush();
            bw.close();
            return;
        }
        
        if (Integer.parseInt(secondline[0]) != 0 )
        {
            for (int i =1 ; i<secondline.length ; i++)
                {
                    whoknowtruth.add(Integer.parseInt(secondline[i]));
                }
        }

        List<List<Integer>> partyperson = new ArrayList<>();

         for (int i = 0; i <M; i++) {
            partyperson.add(new ArrayList<>());
        }

        for (int i = 0 ; i<M ; i++)
            {
                String [] partyline = br.readLine().split(" ");
                List<Integer> newparty = partyperson.get(i);
                for (int j = 1 ; j<partyline.length; j++)
                    {
                        newparty.add(Integer.parseInt(partyline[j]));
                    }
            }

        int nowindex = 0;

        while(nowindex < M)
            {
                if(canlieparty[nowindex])
                {
                    nowindex+=1;
                    continue;
                }

                //파티를 돌다가
                List<Integer> nowpartyperson = partyperson.get(nowindex);

                //해당 파티의 사람 중 진실아는 사람에 있다면.
                boolean anyoneknowtruth = false;

                for (int i = 0 ; i<nowpartyperson.size(); i++)
                    {
                        if (whoknowtruth.contains(nowpartyperson.get(i)))
                        {
                            anyoneknowtruth = true;
                            break;
                        }
                    }

                
                //해당 파티의 사람들 모두 다 집어넣고

                if(anyoneknowtruth)
                {
                    for (int i = 0 ; i<nowpartyperson.size() ; i++)
                        {
                            whoknowtruth.add(nowpartyperson.get(i));
                        }

                    canlieparty[nowindex] = true;
                    nowindex = 0;
                    continue;
                    
                }

                nowindex+=1;

            }

        int answer = 0 ;
        
        for (int i = 0; i<canlieparty.length ; i++)
            {
                if(!canlieparty[i])
                {
                    answer +=1;
                }
            }
        bw.write(String.valueOf(answer));
        bw.close();


        System.out.println(Arrays.asList(canlieparty));


        




    }
}