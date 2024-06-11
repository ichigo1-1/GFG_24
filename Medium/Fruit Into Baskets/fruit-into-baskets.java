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

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        
             int l = 0;
             int n=fruits.length;
    int r = 0;
    int max = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();

    while (r < n) {
        hm.put(fruits[r], hm.getOrDefault(fruits[r], 0) + 1);
        
            //can use while here but it will take more time
            if (hm.size() > 2) {
                hm.put(fruits[l], hm.get(fruits[l]) - 1);
                if (hm.get(fruits[l]) == 0) {
                    hm.remove(fruits[l]);
                }
                l++;
            }
        
        
        max = Math.max(max, r - l + 1);
        r++;
    }
    
    return max;  
    }
}
