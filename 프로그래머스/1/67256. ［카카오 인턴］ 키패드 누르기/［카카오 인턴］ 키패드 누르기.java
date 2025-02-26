import java.util.*;

class Solution {
    public int leftx =3;
    public int lefty = 0;
    public int rightx = 3;
    public int righty = 2;
    
    
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        //numbers를 돌면서
        
        for (int number :numbers)
        {
            if (number==1)
            {
                sb.append("L");
                leftx = 0;
                lefty=0;
            } else if (number==4)
            {
                sb.append("L");
                leftx = 1;
                lefty = 0;
            } else if (number==7)
            {
                sb.append("L");
                leftx = 2;
                lefty = 0;
            } else if (number==3)
            {
                sb.append("R");
                rightx = 0;
                righty = 2;
            }  else if (number==6)
            {
                sb.append("R");
                rightx = 1;
                righty = 2;
            } else if (number==9)
            {
                sb.append("R");
                rightx = 2;
                righty = 2;
            } 
            
            else {
                //2580일떄 
                int comparex = 0;
                int comparey = 0;

if (number == 2) {
    comparex = 0; 
    comparey = 1;
} else if (number == 5) {
    comparex = 1; 
    comparey = 1;
} else if (number == 8) {
    comparex = 2; 
    comparey = 1;
} else if (number == 0) {
    comparex = 3; 
    comparey = 1;
}

                
                // double leftcompare = Math.sqrt(Math.pow(Math.abs(comparey-lefty),2)+Math.pow(Math.abs(comparex-leftx),2));
                // double rightcompare = Math.sqrt(Math.pow(Math.abs(righty-comparey),2)+Math.pow(Math.abs(comparex-rightx),2));
                
                int leftcompare = Math.abs(comparex - leftx) + Math.abs(comparey - lefty);
                int rightcompare= Math.abs(comparex - rightx) + Math.abs(comparey - righty);
                
                if (leftcompare<rightcompare)
                {
                    leftx = comparex;
                    lefty = comparey;
                    sb.append("L");
                } else if (leftcompare>rightcompare)
                {
                    rightx= comparex;
                    righty= comparey;
                    sb.append("R");
                } else {
                    if (hand.equals("right"))
                    {
                        rightx= comparex;
                        righty= comparey;
                        sb.append("R");
                    } else {
                        leftx = comparex;
                        lefty = comparey;
                        sb.append("L");
                    }
                }
            }
            
        }
        
        
        
        return sb.toString();
    }
}