//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int findMin(int A[], int n)
    {
        //complete the function here
        int low=0;
        int high=n-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            //sort check
            if(A[low]<=A[mid])//left sorred
            {
                
                if(ans>A[low])
                {
                    ans=A[low];
                    index=low;
                }
                low=mid+1;
            }
            else if(A[mid]<=A[high])
            {
            
                 if(ans>A[mid])
                {
                    ans=A[mid];
                    index=mid;
                }
                high=mid-1;
            }
            
        }
        return index;
        
    }
    int findKRotation(int arr[], int n) {
        // code here
        
        //index return kardo of the smallest element
        return findMin(arr,n);
        
        
    }
}