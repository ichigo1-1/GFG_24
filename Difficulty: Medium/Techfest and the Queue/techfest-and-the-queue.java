//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static long count(long x)
    {
        long powercount=0;
        //note if you want to find prime factors
        //go till sqrt of number
        //or else i*i=x;{removing sqrt by multiplying i}
        for(int i=2;i*i<=x;i++)
        {
            //this ill stop if x bec
            while(x%i==0)
            {
                x/=i;
                powercount++;
            }
        }
        //11 wala case
        //where powercount=0 jo ki nahi hona tha 1 hona tha but bec of going till sqrt it skiped
        //so checking if the number remained untouched i.e 1 nahi bana after diving 
        //it means waisa ka waisa hi reh gaya number
        //so just incr. counter by 1
        
        if(x!=1){
            powercount++;
        }
        return powercount;
        
    }
    public static long sumOfPowers(long a, long b) {
        // code here
        long result=0;
        while(a<=b)
        {
            result+=count(a);
            a++;
        }
        return result;
    }
}
        
