//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        int ans=0;
        int zero=0;
        int one=0;
        for(int it:a)
        {
            if(it==0)
            {
                zero++;
            }
            else{
                //beacuse 1 will turn to 0 and will not contribute too ans which is zeroes in this  case
                zero--;
                one++;
            }
            ans=Math.max(zero,ans);
            if(zero<0)
            {
                zero=0;
            }
        }
        return one+ans;
    }
}
