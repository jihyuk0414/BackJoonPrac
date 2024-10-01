import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] inputarr1 = br.readLine().split(" ");
        int S = Integer.parseInt(inputarr1[0]);
        int P = Integer.parseInt(inputarr1[1]);

        String inputstr = br.readLine();
        int answer = 0 ;

        char [] sarr = new char[S];

        for (int i = 0 ; i < S ; i ++)
            {
                sarr[i] = inputstr.charAt(i);
            }

        String [] inputarr2 = br.readLine().split(" ");

        int [] acgtnum  = new int[4] ;

        for (int i = 0 ;i<4 ; i++)
            {
                acgtnum[i] = Integer.parseInt(inputarr2[i]);
            }
        
        char [] acgtarr = {'A','C','G','T'};
        
        Map<Character, Integer> answermap = new HashMap<>();
        for (int i = 0 ; i<4; i++)
            {
                answermap.put(acgtarr[i],acgtnum[i]);
            }

        Map<Character, Integer> mymap = new HashMap<>();

        //최초 초기화

          for (int i = 0 ; i < 4; i++)
            {
                mymap.put(acgtarr[i],0); 
            }

        
        for (int i = 0 ; i < P; i++)
            {
                mymap.put(sarr[i],mymap.get(sarr[i])+1); 
            }

        int start = 0 ;
        int end = P-1; 

        while (end<S)
            {
                if (
                    mymap.get('A') >= answermap.get('A') &&
                    mymap.get('C') >= answermap.get('C') &&
                    mymap.get('G') >= answermap.get('G') &&
                    mymap.get('T') >= answermap.get('T') 
                )
                {
                    answer +=1 ;
                }

                if (mymap.containsKey(sarr[start]))
                {
                    mymap.put(sarr[start],mymap.get(sarr[start])-1);
                } 
                start += 1; 

                end += 1;
                if (end == S )
                {
                    break;
                }
                if (mymap.containsKey(sarr[end]))
                {
                    mymap.put(sarr[end],mymap.get(sarr[end])+1);
                } 
                
                
            }

        bw.write(String.valueOf(answer));
        bw.close();
        
    }
}