
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int answerlen = 0 ;
        for (String oneline : musicinfos)
        {
            String [] onelinecheck = oneline.split(",");
            String originmusic = onelinecheck[3];
            
            //처음 시간, 끝시간 차이 계산
            String [] startarr = onelinecheck[0].split(":");
            int start = Integer.parseInt(startarr[0])*60 + Integer.parseInt(startarr[1]); 
            
            String [] endarr = onelinecheck[1].split(":");
            int end = Integer.parseInt(endarr[0])*60 + Integer.parseInt(endarr[1]); 
            
            int time = end-start; //몇 분 실행되었는가
            //그 시간만큼 반복 ,부족하면 substring
            StringBuilder sb = new StringBuilder();
            originmusic = originmusic.replace("C#", "c")
                                   .replace("D#", "d")
                                   .replace("F#", "f")
                                   .replace("G#", "g")
                .replace("B#", "b")
                                   .replace("A#", "a");
                                   
            int len = originmusic.length();
            for(int i = 0; i < time; i++) {
                sb.append(originmusic.charAt(i % len));
            }
            originmusic = sb.toString();
            // C#이랑 C랑 다르게 판단되어야 함
            
            if (check (m, originmusic))
            {
                if (answer.equals(""))
                {
                    answerlen = time;
                    answer = onelinecheck[2];
                } else if (time > answerlen)
                {
                    answerlen = time;
                    answer = onelinecheck[2];
                }
            }
            
            
        }
        answer = answer.equals("") ? "(None)" : answer;
        return answer;
    }
    
  public boolean check(String m, String musicString) {
    m = m.replace("C#", "c")
         .replace("D#", "d")
         .replace("F#", "f")
         .replace("G#", "g")
        .replace("B#", "b")
         .replace("A#", "a");
    
    musicString = musicString.replace("C#", "c")
        .replace("B#", "b")                    
        .replace("D#", "d")
                            .replace("F#", "f")
                            .replace("G#", "g")
                            .replace("A#", "a");
    
    return musicString.contains(m);
}
}