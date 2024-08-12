import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ; 
        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] Nlist = new int [N];

        for (int i = 0 ; i < N ; i ++)
            {
                Nlist[i] = sc.nextInt();
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

        System.out.println(answer);
    }
}