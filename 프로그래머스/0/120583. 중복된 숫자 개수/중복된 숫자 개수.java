class Solution {
    public int solution(int[] array, int n) {
        int ncnt = 0;
        for (int i = 0 ;i<array.length;i++)
        {
            if(array[i]==n)
            {
                ncnt+=1;
            }
            
        }
        return ncnt;
    }
}