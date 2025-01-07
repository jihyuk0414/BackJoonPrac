    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    // The main method must be in a class named "Main".
    class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
            int T = Integer.parseInt(br.readLine());
            
            StringBuilder sb= new StringBuilder();
            for (int x= 0 ; x<T ; x++)
                {
                    String oneline = br.readLine();
                    
                    int N = Integer.parseInt(br.readLine());
                    List<Integer> originarr = new ArrayList<>();
    
                    //입력 받아야된다
                    String arrlinefirst = br.readLine();
                    String [] arrstr = arrlinefirst.substring(1,arrlinefirst.length()-1).split(",");
                    for (int i = 0 ; i<N ; i++)
                        {
                            originarr.add(Integer.parseInt(arrstr[i]));
                        }
    
                    boolean save = true;
                    boolean isreverse =false;
    
                    for (int i = 0 ; i<oneline.length() ; i++)
                        {
                            if(oneline.charAt(i) == 'R')
                            {
                                isreverse = !isreverse;
                            } else if (oneline.charAt(i) == 'D')
                            {
                                if(!removefirst(originarr,isreverse))
                                {
                                    save= false;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        }
    
                    if(save)
                    {
                        if(isreverse)
                        {
                            change(originarr);
                        }
                        sb.append("[");
                        for (int i = 0 ; i<originarr.size() ; i++)
                            {
                                sb.append(String.valueOf(originarr.get(i)));
                                if(i!= (originarr.size()-1))
                                {
                                    sb.append(",");
                                }
                            }
                        sb.append("]" + "\n");
                    } else {
                        sb.append("error"+"\n");
                    }
                }
            bw.write(sb.toString());
            bw.close();
    
        }
    
        public static void change (List<Integer> reversearr)
        {
            Collections.reverse(reversearr);
        }
    
    
        public static boolean removefirst(List<Integer> reversearr, boolean isreverse)
        {
            if(reversearr.size() == 0)
            {
                return false;
            }
            if (!isreverse)
            {
                reversearr.remove(0);
            } else {
                reversearr.remove(reversearr.size()-1);
            }
    
            return true;
        }
    }