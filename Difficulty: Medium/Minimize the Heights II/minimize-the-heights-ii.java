//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] A, int n, int K) {
        // code here
       if(A.length==1||A.length==0)
        {
            return 0;
        }
             Arrays.sort(A);
             int lar=A[A.length-1];
             int small=A[0];
             int diff=lar-small;
             int max,min;
             for(int i=1;i<A.length;i++)
             {
                 if(A[i]-K<0)
                 {
                     continue;
                 }
                 max=Math.max(A[i-1]+K,A[A.length-1]-K);
                 min=Math.min(A[i]-K,A[0]+K);
                diff=Math.min(diff,max-min);
             }
             return diff;
    }
}
