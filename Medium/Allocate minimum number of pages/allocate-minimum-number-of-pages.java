//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages
    public static int possible(int[]A,int max_pages,int students,int N)
    {
        int pages=0;
        int student=1;
        for(int i=0;i<N;i++)
        {
            if(pages+A[i]<=max_pages)
            {
                pages+=A[i];
            }
            else{
                student++;
                pages=A[i];
            }
        }
        return student;
        
    }
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
      if(M>N)
        {
            return -1;
        }
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<N;i++)
        {
            low=Math.max(low,A[i]);
            high+=A[i];
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            int pages=possible(A,mid,M,N);
            if(pages<=M)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
};