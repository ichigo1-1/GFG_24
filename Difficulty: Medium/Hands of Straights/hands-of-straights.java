//{ Driver Code Starts
// Initial Template for Java

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
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int it:hand)
        {
            pq.add(it);
        }
        while(!pq.isEmpty())
        {
            int cur=pq.poll();
            for(int i=1;i<groupSize;i++)
            {
                if(!pq.remove(cur+i))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
