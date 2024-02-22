//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String>ans=new ArrayList<>();
        String ds="";
        char[]arr=S.toCharArray();
        boolean []flag=new boolean[arr.length];
        backtrack(ans,ds,flag,arr);
        Collections.sort(ans);
        return ans;
    }
    public void backtrack(ArrayList<String>ans,String ds,boolean []flag,char[]arr)
    {
        if(ds.length()==arr.length)
        {
            ans.add(ds);
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(!flag[i])
            {
                ds+=arr[i];
                flag[i]=true;
                backtrack(ans,ds,flag,arr);
                ds=ds.substring(0,ds.length()-1);
                flag[i]=false;
            }
            
        }
        
    }
	   
}
