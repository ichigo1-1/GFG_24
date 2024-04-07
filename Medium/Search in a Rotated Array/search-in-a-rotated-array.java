//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            int A[] = new int[n];
            String s[]=in.readLine().trim().split(" ");
            for (int i = 0;i < n;i++)
            {
                A[i] = Integer.parseInt(s[i]);
            }
            int key = Integer.parseInt(in.readLine().trim());
            
            out.println(new Solution().search(A, 0, n - 1, key));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
   int search(int A[], int l, int h, int key) {
    while (l <= h) {
        int mid = l + (h - l) / 2;
        
        if (A[mid] == key) {
            return mid;
        }
        
        // If the left half is sorted
        if (A[l] <= A[mid]) {
            // If the key is in the left half
            if (A[l] <= key && key <= A[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // If the right half is sorted
        else {
            // If the key is in the right half
            if (A[mid] <= key && key <= A[h]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
    }
    return -1; // Key not found
}

}