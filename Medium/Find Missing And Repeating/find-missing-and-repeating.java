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
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[]res=new int[2];
        // for(int i=0;i<arr.length;i++)
        // {
        //     for(int j=i+1;j<n;j++)
        //     {
        //         if(arr[i]==arr[j])
        //         {
        //           res[0]=arr[i]; 
        //         }
        //     }
        // }
        // for(int i=1;i<=n;i++)
        // {
        //     boolean flag=false;
        //     for(int j=0;j<n;j++)
        //     {
        //         if(arr[j]==i)
        //         {
        //             flag=true;
        //         }
        //     }
        //     if(flag==false)
        //     {
        //         res[1]=i;
        //         break;
        //     }
        // }
        // return res;
        int[]hasharray=new int[n+1];
        for(int i=0;i<arr.length;i++)
        {
            hasharray[arr[i]]++;
        }
        int miss=-1;
        int reap=-1;
        for (int i = 1; i <= n; i++) {
        if (hasharray[i] == 2) {
            reap = i;
        } else if (hasharray[i] == 0) {
            miss = i;
        }
    }

    res[0] = reap;
    res[1] = miss;
    return res;
        
    }
}