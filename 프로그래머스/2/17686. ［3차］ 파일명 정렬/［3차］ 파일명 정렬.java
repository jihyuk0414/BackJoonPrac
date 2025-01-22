import java.util.*;
import java.io.*;

class Solution {
    public List<Character> numberlist = new ArrayList<>();
    public String[] solution(String[] files) {
        String [][] comparefiles = new String [files.length][3];
        
        for (char i = '0' ; i<='9' ; i++)
        {
            numberlist.add(i);
        }

        for (int i = 0 ; i<files.length;  i++)
        {
            String nowstr = files[i];
            
            String head = "";
            String number = "";
            String tail = "";
            
            int nowstatus = 0;
            int nowindex = 0;
            while (nowindex < nowstr.length())
            {
                if (nowstatus ==0)
                {
                    if (numberlist.contains(nowstr.charAt(nowindex)))
                        {
                            nowstatus+=1;
                            continue;
                        } else {
                            head += nowstr.charAt(nowindex);
                            nowindex +=1;  
                        }
                } else if (nowstatus ==1)
                {
                    if (!numberlist.contains(nowstr.charAt(nowindex)))
                        {
                            nowstatus+=1;
                            continue;
                        }
                    number += nowstr.charAt(nowindex);
                    nowindex +=1;        
                } else {
                    tail += nowstr.charAt(nowindex);
                    nowindex +=1;
                }
           }
            System.out.println(" head : " + head+ " number : "+ number + " tail : " + tail);
            String [] newarr = new String [] {head,number,tail};
            comparefiles[i] = newarr;
        }
        
        Arrays.sort(comparefiles, (a,b) -> {
            if (a[0].toLowerCase().equals(b[0].toLowerCase()))
            {
                if (Integer.parseInt(a[1]) == Integer.parseInt(b[1]))
                {
                    return 0;
                } else {
                    return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
                }
            } else {
                return a[0].toLowerCase().compareTo(b[0].toLowerCase());
            }
        });
        
        String [] answer = new String [comparefiles.length];
        
        for (int i = 0 ; i<comparefiles.length; i++)
        {
            String nowstr2 = "";
            for (int j = 0 ; j<3 ; j++)
            {
                nowstr2+= comparefiles[i][j];
            }
            answer [i] = nowstr2;
        }
        
        return answer;
    }
}