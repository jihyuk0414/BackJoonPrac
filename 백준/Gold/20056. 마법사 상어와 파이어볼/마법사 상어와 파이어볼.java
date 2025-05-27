import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M,K ;
    static Map<String,List<int []>> mymap = new HashMap<>();
    static int [] dx = new int[]{-1,-1,0,1,1,1,0,-1};
    static int [] dy = new int [] {0,1,1,1,0,-1,-1,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] oneline = br.readLine().split(" ");

        N = Integer.parseInt(oneline[0]);        
        M = Integer.parseInt(oneline[1]);        
        K = Integer.parseInt(oneline[2]);

        for (int i = 0 ;i<M; i++)
            {
                String [] marr = br.readLine().split(" ");
                int [] onearr = new int [5]; //x,y,질량,방향,속력
                
                for (int j = 0 ;j<5; j++)
                    {
                        onearr[j] = Integer.parseInt(marr[j]);
                    }

                onearr[0]--; 
                onearr[1]--; 
    
                String key = onearr[0] + "," + onearr[1];
                if (!mymap.containsKey(key)) {
                    mymap.put(key, new ArrayList<>());
                }
                mymap.get(key).add(onearr);
                
            }

        for (int day= 0 ; day<K; day++)
            {
                Map<String,List<int []>> newmap = new HashMap<>();
                for (String key : mymap.keySet())
                    {
                    List<int[]> fireballs = mymap.get(key); 
                    for (int[] now : fireballs) { 
                        int newR = (now[0] + dx[now[4]] * now[3] % N + N) % N;
                        int newC = (now[1] + dy[now[4]] * now[3] % N + N) % N;
                        
                        now[0] = newR;
                        now[1] = newC;
                        
                        String newKey = newR + "," + newC;
                        if (!newmap.containsKey(newKey)) {
                            newmap.put(newKey, new ArrayList<>());
                        }
                        newmap.get(newKey).add(now);
                    }
                } 

                mymap = newmap;
                
                Map<String, List<int[]>> finalMap = new HashMap<>();
                        
                for (String key : mymap.keySet())
                    {
                        
                        List<int[]> oneplacelist = mymap.get(key);

                         if (oneplacelist.size() == 1) {
                            if (!finalMap.containsKey(key)) {
                                finalMap.put(key, new ArrayList<>());
                            }
                            finalMap.get(key).add(oneplacelist.get(0));
                        }
                        else {
                                 boolean allhol = true;
                                boolean allzzak = true;

                                int sumweight = 0 ;
                                int summove = 0;
                                for (int [] onearr : oneplacelist)
                                    {
                                        if(onearr[4] %2 == 0)
                                        {
                                            allhol = false; 
                                        } else {
                                            allzzak = false; 
                                        }
                                        sumweight += onearr[2];
                                        summove += onearr[3];
                                    }
                            
                                int newWeight = sumweight / 5;
                                int newSpeed = summove / oneplacelist.size();

                                if(newWeight > 0)
                                {
                                    String [] myarr= key.split(",");
                                    int savex = Integer.parseInt(myarr[0]);
                                    int savey = Integer.parseInt(myarr[1]);

                                if(!finalMap.containsKey(key)) 
                                {
                                    finalMap.put(key, new ArrayList<>()); 
                                }
                                    if(allhol || allzzak) 
                                    {
                                        for (int dir = 0; dir < 8; dir += 2) {
                                            finalMap.get(key).add(new int[]{savex, savey, newWeight, newSpeed, dir});
                                        }
                                    }
                                    else 
                                    {
                                        for (int dir = 1; dir < 8; dir += 2) {
                                            finalMap.get(key).add(new int[]{savex, savey, newWeight, newSpeed, dir}); // r,c -> savex,savey
                                        }
                                    }
                                }
                        }
                    }
                mymap = finalMap; 
            }

                       int totalWeight = 0;
        for (List<int[]> fireballs : mymap.values()) {
            for (int[] fireball : fireballs) {
                totalWeight += fireball[2];
            }
        }
        
        bw.write(String.valueOf(totalWeight));
        bw.flush();
        bw.close();
    }
}