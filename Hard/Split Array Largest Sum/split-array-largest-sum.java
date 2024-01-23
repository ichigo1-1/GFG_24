//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int possible(int[] nums,int num,int k)
    {
        int labour=1;
        int cur=0;
        for(int i=0;i<nums.length;i++)
        {
            if(cur+nums[i]<=num)
            {
                cur+=nums[i];
            }
            else{
                labour++;
                cur=nums[i];
            }
        }
        return labour;
    }
    static int splitArray(int[] nums , int n, int k) {
        // code here
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<nums.length;i++)
        {
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(possible(nums,mid,k)<=k)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
};