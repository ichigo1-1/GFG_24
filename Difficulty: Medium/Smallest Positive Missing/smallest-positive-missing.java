//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        int n=arr.length;
       int max_pos = Integer.MIN_VALUE;
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] >= 1 && arr[i] <= n) {
            max_pos = Math.max(max_pos, arr[i]);
            count++;
        }
    }
    if (count == 0) {
        return 1;
    }
    int[] countArr = new int[max_pos + 1];
    for (int i = 0; i < n; i++) {
        if (arr[i] >= 1 && arr[i] <= n) {
            countArr[arr[i]]++;
        }
    }
    for (int i = 1; i < countArr.length; i++) {
        if (countArr[i] == 0) {
            return i;
        }
    }
    return max_pos + 1;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends