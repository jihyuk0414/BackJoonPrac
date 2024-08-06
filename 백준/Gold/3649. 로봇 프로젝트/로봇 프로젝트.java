import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        while (true) 
        {
            try{
                
                    int x = scanner.nextInt() * 10000000;;
                    int N = scanner.nextInt(); 

                    Integer [] inputlist= new Integer [N];

                    for (int i = 0 ; i < N ; i ++)
                        {
                            Integer one = scanner.nextInt();
                            inputlist[i] = one;
                        }

                    Arrays.sort(inputlist);
                    int endindex = N-1;
                    int startindex = 0 ;

                    boolean flag = true;

                    while (startindex < endindex)
                        {
                            int sumcnt = inputlist[startindex]+inputlist[endindex];

                            if (sumcnt == x)
                            {
                                System.out.println("yes "+ inputlist[startindex]+ " "+inputlist[endindex]);
                                flag = false;
                                break ;
                            }

                            else if(sumcnt < x) 
                            {
                                startindex += 1;
                            }
                            else 
                            {
                                endindex -= 1;                           
                            }
                    
                        }
                    if (flag)
                    {
                        System.out.println("danger");
                    }
            } catch(Exception e)
                {
                    break;
                }
        }
    }
}