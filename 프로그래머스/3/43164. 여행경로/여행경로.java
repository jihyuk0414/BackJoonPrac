import java.util.*;
class Solution {
    
    public Map<String, List<String>> map = new HashMap<>();
    public int n,m;
    public Map<String, List<Boolean>> used = new HashMap<>();
    public boolean finished = false;
    
    public String[] solution(String[][] tickets) {
        n = tickets.length;
        m = tickets[0].length;
        
        for (int i = 0; i < n; i++) {
            String [] now = tickets[i];
            String a = now[0];
            String b = now[1];
            if (map.keySet().contains(a)) {
                map.get(a).add(b);
                used.get(a).add(false); 
            } else {
                map.put(a, new ArrayList<>());
                map.get(a).add(b);
                used.put(a, new ArrayList<>());
                used.get(a).add(false);
            }
        }
        
        for (String key : map.keySet()) {
            List<String> destinations = map.get(key);
            List<Boolean> usedList = used.get(key);
            
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < destinations.size(); i++) {
                indices.add(i);
            }
            
            Collections.sort(indices, (i1, i2) -> destinations.get(i1).compareTo(destinations.get(i2)));
            
            List<String> sortedDest = new ArrayList<>();
            List<Boolean> sortedUsed = new ArrayList<>();
            
            for (int idx : indices) {
                sortedDest.add(destinations.get(idx));
                sortedUsed.add(usedList.get(idx));
            }
            
            map.put(key, sortedDest);
            used.put(key, sortedUsed);
        }
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        DFS("ICN", path, 0); 
        
        return path.toArray(new String[0]);
    }
    
    public boolean DFS(String start, List<String> path, int count) {

        if (count == n) {
            finished = true;
            return true;
        }
        
        if (!map.containsKey(start)) {
            return false;
        }
        
        List<String> cango = map.get(start);
        List<Boolean> usedTickets = used.get(start);
        
        for (int i = 0; i < cango.size(); i++) {
            if (!usedTickets.get(i)) {
                String next = cango.get(i);
                
                usedTickets.set(i, true);
                path.add(next);
                
                if (DFS(next, path, count + 1)) {
                    //다 돌았따면?  끝
                    return true;
                }
                
                //다 돌지 못했다면 
                usedTickets.set(i, false);
                path.remove(path.size() - 1);
            }
        }
        
        return false;
    }
}