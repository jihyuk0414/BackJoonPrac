import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static List<List<Integer>> wheels = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0 ; i<4 ; i++){
            List<Integer> newlist = new LinkedList<>();
            wheels.add(newlist);
        }

        for (int i = 0 ; i<4 ; i++){
            String oneline = br.readLine();
            List<Integer> nowlist = wheels.get(i); 
            for (int j = 0 ; j < oneline.length(); j++)
                {
                    nowlist.add(Character.getNumericValue(oneline.charAt(j)));
                }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0 ; i <K ;i++)
            {
                String [] oneline = br.readLine().split(" ");
                int whatwheel = Integer.parseInt(oneline[0])-1;
                int where = Integer.parseInt(oneline[1]);

                boolean checkdone = false;

                int [] rotations= new int[4];
                rotations[whatwheel] = where;
                
                    
                for (int j = whatwheel; j > 0; j--) {
                if (wheels.get(j).get(6) != wheels.get(j-1).get(2)) {
                    rotations[j-1] = -rotations[j];
                } else {
                    break;
                    }
                }
            
            
                for (int j = whatwheel; j < 3; j++) {
                    if (wheels.get(j).get(2) != wheels.get(j+1).get(6)) {
                        rotations[j+1] = -rotations[j];
                    } else {
                        break;
                    }
                }

                for (int j = 0; j < 4; j++) {
                    if ( rotations[j] != 0) {
                    run(j, rotations[j]);
                }
                }
            }

        int answer=  0 ;
        
        for (int i = 0 ; i<4 ; i++){
            if (wheels.get(i).get(0) ==1 )
            {
                answer += Math.pow(2,i);
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        
   
    }

    public static void run(int whatwheel, int where)
    {
        List<Integer> onewheel = wheels.get(whatwheel);

        if (where == 1)
        {
            int lastone = onewheel.get(onewheel.size()-1);
            onewheel.remove(onewheel.size()-1);
            onewheel.add(0,lastone);
        } else{
            int firstone = onewheel.get(0);
            onewheel.remove(0);
            onewheel.add(firstone);
        }
    }
}
