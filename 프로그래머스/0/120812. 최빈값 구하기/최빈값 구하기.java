class Solution {
    public int solution(int[] array) 
    {
        int answer = 0 ;
        int[] myarr = new int[1000] ;
        
        for (int i = 0; i<array.length; i++)
        {
            int val = array[i];
            myarr[val]+=1 ; //빈도수 저장
        }
        
        int maxval = 0;//최대 빈도값
        int maxindex = 0;
        
        for (int i = 0; i<myarr.length; i++)
        {
            if (maxval<myarr[i])
            {
                maxindex = i;// 해당 빈도의 index ex)3은 몇번에서 3. 
                maxval = myarr[i] ; 
            }
        }
        
        int howmany = 0 ;
        
        for (int i = 0; i<myarr.length; i++)
        {
            if (maxval == myarr[i])
            {
                howmany += 1; //같은 빈도수
            }
        }
        
        if (howmany == 1)
        {
            return maxindex;
        }
        else{
            return -1;
        }
        
        
        
     
    }
}