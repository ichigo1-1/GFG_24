//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends

class Solution
{
    int[] dp;

    public int solve(int i, int[] arr, int n) {
        // Base case: if index goes beyond the array, return 0
        if (i >= n) {
            return 0;
        }

        // Memoization: if already computed, return dp[i]
        if (dp[i] != -1) {
            return dp[i];
        }

        // Choose to steal from the current house or skip it
        int steal = arr[i] + solve(i + 2, arr, n);
        int skip = solve(i + 1, arr, n);

        // Store the maximum of stealing or skipping
        dp[i] = Math.max(steal, skip);

        return dp[i];
    }

    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        // Initialize dp array
        dp = new int[n];
        Arrays.fill(dp, -1);

        // Solve from the 0th index
        return solve(0, arr, n);
    }
}
