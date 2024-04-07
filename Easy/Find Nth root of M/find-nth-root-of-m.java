//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int cal(int mid, int n, int m) {
        long ans = 1; // Using long to avoid integer overflow
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) {
                return 2; // Indicate that result is greater
            }
        }
        if (ans == m) {
            return 0; // Indicate exact match
        }
        return 1; // Indicate result is less than m
    }
    
    public int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Corrected calculation of mid
            int calculate = cal(mid, n, m);
            if (calculate == 0) {
                return mid; // Exact match found
            } else if (calculate == 2) {
                high = mid - 1; // Adjust high for values greater than m
            } else {
                low = mid + 1; // Adjust low for values less than m
            }
        }
        return -1; // Not found
    }
}
