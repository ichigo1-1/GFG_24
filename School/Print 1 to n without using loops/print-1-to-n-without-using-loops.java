//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ob.printTillN(N);
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static void rec(int start,int N)
    {
        // if(start>n)
        // {
        //     return;
        // }
        // System.out.print(start+" ");
        // start++;
        // rec(start,n);
        
        
        //using backtracking
        if(start<1)
        {
            return;
        }
        rec(start-1,N);
        System.out.print(start+" ");
    }
    static void printTillN(int N){
        // code here
        rec(N,N);
    }
}