class Solution {
    public int answer = 0 ;
    public int idx = -1;
    public char [] wordarr =  {'A','E','I','O','U'};
    public int solution(String word) {
        dfs("",word,0);
        return answer;
    }
    
    public void dfs(String val, String word, int depth)
    {        
        idx +=1;
        
        if (val.equals(word))
        {
            answer = idx;
            return;
        }
        
        if (depth == 5)
        {
            return;
        } 

        for (int i =0  ; i<5;  i++)
            {
                dfs(val+wordarr[i], word, depth+1);
            }
    
        
    }
}