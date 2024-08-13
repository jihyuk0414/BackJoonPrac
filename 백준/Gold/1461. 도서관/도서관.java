import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        // Scanner sc = new Scanner(System.in) ; 
        // int N = sc.nextInt();
        // int M = sc.nextInt();

        int [] Nlist = new int [N];

        String [] input = br.readLine().split(" ");

        for (int i = 0 ; i < N ; i ++)
            {
                Nlist[i] = Integer.parseInt(input[i]);
            }

        ArrayList<Integer> pluslist = new ArrayList<>();
        ArrayList<Integer> minuslist = new ArrayList<>();
        int maxdir = 0 ;

        for (int i = 0; i < N ; i ++ )
        {
                if (Nlist[i] >= 0 )
                {
                    pluslist.add(Nlist[i]);
                }
                else{
                    minuslist.add(Nlist[i]);
                }

            if(Math.abs(Nlist[i]) > Math.abs(maxdir))
                {
                    maxdir = Nlist[i];
                }
        }

      
        // 올바른 정렬 메서드 사용
        Collections.sort(pluslist, Collections.reverseOrder());
        Collections.sort(minuslist);

        int answer = 0 ;

        for (int i = 0 ; i<pluslist.size(); i += M)
            {
                if (pluslist.get(i) != maxdir)
                {
                    answer += pluslist.get(i);
                }
            }

        for (int i = 0 ; i<minuslist.size(); i += M)
            {
                if (minuslist.get(i) != maxdir)
                {
                    answer += Math.abs(minuslist.get(i));
                }
            }

        answer *= 2 ;
        answer += Math.abs(maxdir);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
}