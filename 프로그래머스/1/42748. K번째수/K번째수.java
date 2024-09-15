import java.util.* ;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer>answerlist = new ArrayList<>();
        
        for (int i = 0 ;i < commands.length; i++)
        {
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int k = commands[i][2]-1;
            
            List<Integer> comparelist = new ArrayList<>();
            
            for(int j = start;j<end+1;j++)
            {
                comparelist.add(array[j]);
            }
            Collections.sort(comparelist);
            
            answerlist.add(comparelist.get(k));
            
        }
        int [] answer = new int[answerlist.size()];
        for(int i=0; i<answerlist.size(); i++)
        {
            answer[i] = answerlist.get(i);
        }
        return answer;
    }
}