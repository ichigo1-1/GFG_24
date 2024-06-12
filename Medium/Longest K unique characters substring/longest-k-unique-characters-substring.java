//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
       int i = 0;
        int j = 0;
        int n = s.length();
        int max = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        
        while (j < n) {
            // Add the current character to the hashmap and increment its count
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
            
            // If the size of the hashmap is less than or equal to k, update the maximum length
            if (hm.size() == k) {
                max = Math.max(max, j - i + 1);
            } 
            
            // If the size of the hashmap is greater than k, shrink the window from the left
            while (hm.size() > k) {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                if (hm.get(s.charAt(i)) == 0) {
                    hm.remove(s.charAt(i));
                }
                i++;
            }
            
            // Move to the next character
            j++;
        }
        
        return max;
    }
}