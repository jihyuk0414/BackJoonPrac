import java.util.* ; 
class Solution {
    
    static Set<Integer>answerset = new HashSet<>();
    static int answer = 0 ;
    static int N ;
    static String realnum ;
    
    public int solution(String numbers) {
        N = numbers.length();
        realnum = numbers;
        
        boolean [] visited = new boolean[N];
        DFS(visited,0);
        
        System.out.println(answerset);
        
        return answer;
        
        
    }
    
    public static void DFS(boolean[] visited, int nownum)
    {
        if (nownum!= 0 && nownum!=1)
        {
             
            boolean sosu = true;
        
            for (int i = 2 ; i <nownum; i++)
            {
                if(nownum%i == 0)
                {
                    sosu = false ;
                    break;
                }
            }
            
            if(sosu&&!answerset.contains(nownum))
            {
                answerset.add(nownum);
                answer += 1; 
            }
        }
        
      
        
        for(int i = 0 ; i<N; i++)
        {
            if(visited[i] == false)
            {
                visited[i] = true;
                int newnum = 
                    Integer.parseInt(String.valueOf(nownum)+
                                     realnum.charAt(i));
                DFS(visited,newnum);
                visited[i] = false;
            }   
        }
       
    
        
        
    }
}