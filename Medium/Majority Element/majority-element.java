//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int arr[], int size)
    {
        // your code here
        int count=1;
        int maj=arr[0];
        for(int i=1;i<size;i++)
        {
            if(maj==arr[i])
            {
                count++;
            }
            if(count==0)
            {
                maj=arr[i];
                count=1;
            }
            if(maj!=arr[i])
            {
                count--;
            }
        }
        count=0;
        for(int i=0;i<size;i++){
            if(maj==arr[i]) count++;
        }
        if(count>size/2) return maj;
        
        return -1;
        
    }
}