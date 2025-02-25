import java.util.*;

class Solution {
    List<List<Integer>> candidateKeys = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int answer = 0;
        int n = relation.length; 
        int m = relation[0].length;
        for (int i =1 ; i<=m ; i++)
        {
            combination(0,i,new ArrayList<>(), m,relation); //idx,갯수
        }
        return candidateKeys.size();
    }
    
    public void combination(int idx, int cnt , List<Integer> current, int n , String [][] relation)
    {
        if (cnt == 0 )
        {
            //다 뽑았다.
            if (minimal(current))
            {
                if (unique(current, relation))
                {
                    candidateKeys.add(new ArrayList<>(current));
                }
            }
            return;
        }
        
        for (int i = idx; i<n; i++)
        {
            current.add(i);
            combination(i+1,cnt-1,current,n,relation);
            current.remove(current.size()-1);
        }
    }
    
    public boolean minimal(List<Integer> current)
    {
        for (List<Integer> key : candidateKeys) {
            boolean isSubset = true;
            for (int col : key) {
                if (!current.contains(col)) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) {
                return false;
            }
        }
        return true;
    }
    
    public boolean unique (List<Integer> current,  String [][] relation)
    {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int colIdx : current) {
                sb.append(relation[i][colIdx]).append("#");
            }
            
            if (!set.add(sb.toString())) {
                return false;
            }
        }
        
        return true;
    }
}