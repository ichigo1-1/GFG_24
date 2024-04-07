//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    //step 1. get the max for range purpose
    public static int max(int[]piles)
    {
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]>maxi)
            {
                maxi=piles[i];
            }
        }
        return maxi;
    }
    //step 2:- calculate the tim taken
    public static int calculate(int[]piles,int hour,int H,int n)
    {
        int hours=0;
        for(int i=0;i<n;i++)
        {
            hours+=Math.ceil((double)piles[i]/hour);
        }
        return hours;
    }
    
    public static int Solve(int N, int[] piles, int H) {
        // code here
        int low=1;
        int high=max(piles);
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int total=calculate(piles,mid,H,N);
            if(total<=H)
            {
                ans=mid;
                high=mid-1;
            }
            else if(total>H)
            {
                low=mid+1;
            }
        }
        return ans;
    }
}
        
