//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static void swap(int i,int j,long arr1[], long arr2[])
    {
        if(arr1[i]>arr2[j])
        {
            long temp=arr1[i];
            arr1[i]=arr2[j];
            arr2[j]=temp;
        }
      
    }
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        int len=n+m;
        //to get the ceil value
        int gap=(len/2)+(len%2);
        while(gap>0)
        {
            int left=0;
            int right=left+gap;
            while(right<len)
            {
                //3 cases
                //1.left is in arr1 and right in arr2
                //right -n becuse if right is in 1 index and n=4 then right-n will give the index to swap
                //as right is at 5 --- 5-4=1 which is the index to be swapped
                if(left<n && right>=n)
                {
                    swap(left,right-n,arr1,arr2);
                }
                //both in arr2
                else if(left>=n)
                {
                    swap(left-n,right-n,arr2,arr2);
                }
                else{
                    swap(left,right,arr1,arr1);
                }
                left++;
                right++;
            }
            if(gap==1)
            {
                break;
            }
            gap=(gap/2)+(gap%2);
        }
    }
}
