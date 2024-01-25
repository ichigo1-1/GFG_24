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
    static void printTillN(int N){
        // code here
        int[]res=new int[N];
        rec(N,res);
        for(int it:res)
        {
            System.out.print(it+" ");
        }
        
    }
    static void rec(int N,int[]res)
    {
        if(N==0)
        {
            return;
        }
        rec(N-1,res);
        res[N-1]=N;
        
        return;
    }
}