import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a,b) -> {
            if (a[col-1]==b[col-1])
            {
                return b[0]-a[0];
            } else {
                return a[col-1]-b[col-1];
            }
        });
        
        List<Integer> silist = new ArrayList<>();
        
        for (int i = row_begin; i<= row_end ; i++)
        {
            int [] now = data[i-1];
            int S_i = gets_i(now,i);
            silist.add(S_i);
        }
        
        //XOR 하면 됨 .
        answer = silist.get(0);
        //XOR은 같으면 0 ,다르면 1 
        
        for (int i = 1; i<silist.size(); i++)
        {
            answer ^= silist.get(i); 
        }
        
        return answer;
    }
    
    public static int gets_i (int [] target, int i)
    {
        int cnt = 0;
        
        for (int j = 0 ; j<target.length; j++)
        {
            cnt += target[j]%i;
        }
        return cnt;
    }
}