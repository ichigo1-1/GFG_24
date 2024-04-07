//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findOnce(int arr[], int n) {
        // Handle the case when the array has only one element
        if (n == 1) {
            return arr[0];
        }

        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }
        
        int low = 1;
        int high = n - 2;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }
            
            if (mid % 2 == 0) { // even index
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 2; // Move to the next odd index
                } else {
                    high = mid - 1; // Move to the previous even index
                }
            } else { // odd index
                if (arr[mid] != arr[mid + 1]) {
                    low = mid + 1; // Move to the next odd index
                } else {
                    high = mid - 1; // Move to the previous even index
                }
            }
        }
        return -1;
    }
}