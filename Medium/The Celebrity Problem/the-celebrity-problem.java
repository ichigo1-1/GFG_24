//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer>st=new Stack<>();
    	for(int i=0;i<n;i++)
    	{
    	    st.push(i);
    	}
    	while(st.size()>=2)
    	{
    	    int first=st.pop();
    	    int second=st.pop();
    	    if(M[first][second]==1)
    	    {
    	        //agar first sec ko jantai toh woh celeb nahi ho skta so remove
    	        st.push(second);
    	    }
    	    else{
    	        st.push(first);
    	    }
    	}
    	//last element bacha hai that could be the potential celeb candidate
    	int pot=st.pop();
    	for(int i=0;i<n;i++)
    	{
    	    if(i!=pot)//diagonal pe check nahi karnai ex:-2x2 peh no need
    	    {
    	        if(M[i][pot]==0 || M[pot][i]==1)
    	        {
    	            return -1;
    	        }
    	    }
    	}
    	return pot;
    }
}