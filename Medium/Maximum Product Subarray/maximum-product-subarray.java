//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long max=Integer.MIN_VALUE;
        long prod=1;
        long prefix=0;
        long suffix=0;
        for(long it:arr)
        {
           
            prod*=it;
            max=Math.max(prod,max);
             if(it==0)
            {
                prod=1;
            }
        }
        prod=1;
        for(int i=arr.length-1;i>=0;i--)
        {
           
            prod*=arr[i];
            max=Math.max(prod,max);
             if(arr[i]==0)
            {
                prod=1;
            }
        }
        return max;
    }
}