//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
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
      Solution obj = new Solution();
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
     PriorityQueue<Integer>pq=new PriorityQueue<>();
     HashMap<Integer,Integer>hm=new HashMap<>();
     for(int it:arr)
     {
         pq.add(it);
     }
     int rank=0;
     while(!pq.isEmpty())
     {
         int a=pq.poll();
         if(!hm.containsKey(a))
         {
             hm.put(a,++rank);
         }
    }
    
    for(int i=0;i<N;i++)
    {
        arr[i]=hm.get(arr[i]);
    }
    return arr;

  }
}
     