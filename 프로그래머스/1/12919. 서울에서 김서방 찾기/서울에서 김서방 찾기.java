class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int where = 0;
        for(int i=0 ; i<seoul.length; i++)
        {
            if (seoul[i].equals("Kim"))
            {
                where = i;
            }
        }
        answer += "김서방은 ";
        answer += Integer.toString(where);
        answer += "에 있다";
        return answer;
    }
}