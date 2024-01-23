//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int possible(int[]nums,int div,int threshold)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=Math.ceil((double)nums[i]/(double)div);
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
         int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            high=Math.max(high,nums[i]);
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(possible(nums,mid,threshold)<=threshold)
            {
                high=mid-1;   
            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
}