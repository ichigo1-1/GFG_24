//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        // Your code here
        // long sum=0;
        // long S0=0;
        // for(int i=0;i<n;i++)
        // {
        //     sum+=(long)a[i];
        //     S0+=(long)a[i]*i;
        // }
        // long max=S0;
        // long Si=S0;
        // for(int i=0;i<n-1;i++)
        // {
        //     long sip1=Si+sum-n*a[n-i-1];
        //     if(sip1>max)
        //     {
        //         max=sip1;
        //     }
        //     Si=sip1;
        // }
        // return max;
        long max_sum = 0;
        long sum = 0;
        
        for(int i =0;i<n;i++){
            sum += (long)a[i];
            max_sum += (long)a[i]*i;
        }
        long curr = max_sum;
        for(int i =1;i<n;i++){
            curr = curr+(sum-n*(long)a[n-i]);
            
            max_sum = Math.max(curr,max_sum);
        }
        return max_sum;
        
        
    }
}
