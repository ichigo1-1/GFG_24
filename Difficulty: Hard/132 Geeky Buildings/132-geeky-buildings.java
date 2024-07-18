//{ Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.recreationalSpot(arr,n))
                System.out.println("True");
            else
                System.out.println("False");
        }
	}
}
// } Driver Code Ends


//User function template for C++

class Solution{
    static boolean recreationalSpot(int[] arr , int n){
        // Your code goes here 
        Stack<Integer>st=new Stack<>();
        int num3=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--)
        {
            if(arr[i]<num3)
            {
                return true;
            }
            while(st.size()>0 && st.peek()<arr[i])
            {
                num3=st.pop();
            }
            st.push(arr[i]);
        }
        return false;
    }
};