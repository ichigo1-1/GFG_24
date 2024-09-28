//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java


class Solution {
    static int[] dp;

    static int solve(int i, int[] arr, int n) {
        // Base case
        if (i >= n) {
            return 0;
        }

        // Check if already solved
        if (dp[i] != -1) {
            return dp[i];
        }

        // Recurrence relation
        int one = arr[i] + solve(i + 1, arr, n);
        int two = arr[i] + solve(i + 2, arr, n);

        // Memoize result
        dp[i] = Math.min(one, two);

        return dp[i];
    }

    static int minCostClimbingStairs(int[] cost, int N) {
        // Initialize dp array
        dp = new int[N];
        Arrays.fill(dp, -1);

        // Calculate minimum cost starting from either step 0 or step 1
        return Math.min(solve(0, cost, N), solve(1, cost, N));
    }
}
