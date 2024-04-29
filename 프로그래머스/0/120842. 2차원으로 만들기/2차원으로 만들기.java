class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int [num_list.length / n][n];
        int cnt =0 ;
        for (int i =0 ; i<num_list.length ; i++)
        {
            int where =0 ;
            int num = 0;
            if (i!=0)
            {
                where = i/n;
                num = i%n;
                
                answer[where][num] = num_list[i];
                
            }
            else if (i ==0)
            {
                answer[0][0] = num_list[0];
            }
        }
        return answer;
    }
}