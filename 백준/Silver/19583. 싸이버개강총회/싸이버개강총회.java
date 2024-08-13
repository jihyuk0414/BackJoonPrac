import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstInputArr = br.readLine().split(" ");
        int[] inputArr =new int [3];

        for (int i = 0; i < firstInputArr.length; i++) {
            String[] timeStr = firstInputArr[i].split(":");
            int hours = Integer.parseInt(timeStr[0]);
            int minutes = Integer.parseInt(timeStr[1]);
            int totalMinutes = hours * 60 + minutes;
            inputArr[i] = totalMinutes;
        }

        int S = inputArr[0];
        int E = inputArr[1];
        int Q = inputArr[2];

        HashMap<String,Integer> comparedict = new HashMap<>();
        HashSet<String> answerset=  new HashSet<>();
        
        int answer = 0 ;

        
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] onePeopleInput = line.split(" ");
            String onePeopleName = onePeopleInput[1];

            
            String[] timeStr = onePeopleInput[0].split(":");
            int onePeopleHour = Integer.parseInt(timeStr[0]);
            int onePeopleMinute = Integer.parseInt(timeStr[1]);
            int onePeopleTime = onePeopleHour * 60 + onePeopleMinute;
            
            if (onePeopleTime <= S) 
        {
            comparedict.put(onePeopleName,0);
        }
              

        else if (E <= onePeopleTime && onePeopleTime<= Q) {
            if (comparedict.containsKey(onePeopleName)) 
            {
                answerset.add(onePeopleName);
                 answer+=1;
            }
             
        }
          
      

    }

          bw.write(String.valueOf(answerset.size()));
        bw.flush();
        bw.close();
    
}
}