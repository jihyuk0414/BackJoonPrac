import java.util.*;

class Solution {
    public int globaln ;
    public List<List<Integer>> answerlist = new ArrayList<>();
    public int mindepth = Integer.MAX_VALUE;
    
    public int[][] solution(int n) {
        globaln = n;
        
        List<Stack<Integer>> tower = new ArrayList<>();
        for (int i = 0 ; i<3; i++)
        {
            Stack<Integer> oneStack = new Stack<>();
            tower.add(oneStack);
        }
        
        for (int i = n; i>=1 ; i--)
        {
            tower.get(0).push(i);
        }
        
        List<List<Integer>> path = new ArrayList<>();
        
        hanoy(n,0,2,1);
        
        int[][] answer = new int[answerlist.size()][2];
        
        for (int i = 0; i < answerlist.size(); i++) {
            answer[i][0] = answerlist.get(i).get(0);
            answer[i][1] = answerlist.get(i).get(1);
        }
    
        return answer;
    }
    
    public void hanoy(int n, int from , int to, int sub)
    {
        if (n ==0) return;
        
        hanoy(n-1,from,sub,to);
        
        List<Integer> move = new ArrayList<>();
        move.add(from+1);
        move.add(to+1);
        answerlist.add(move);
        
        hanoy(n-1,sub,to,from);
    }
}