//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int T=sc.nextInt();
		while(T-->0)
		{
		    //creating an object of class Print
		    Solution obj=new Solution();
		    int N;
		    
		    //input N
		    N=sc.nextInt();
		    
		    //calling printNos() methdo
		    //of class Print
		    obj.printNos(N);
		    System.out.println();
		    
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java



class Solution
{
    
  public void printNos(int N)
    {
        //Your code here
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

