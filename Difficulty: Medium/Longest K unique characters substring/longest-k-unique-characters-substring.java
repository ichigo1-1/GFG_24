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
        HashMap<Character, Integer> hm = new HashMap<>();
        int ans = -1;
        int i = 0, j = 0;
        int n = s.length();

        while (j < n) {
            // Add current character to the HashMap
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);

            // When we have exactly k distinct characters, calculate the length
            if (hm.size() == k) {
                ans = Math.max(ans, j - i + 1);
            }

            // If the window has more than k distinct characters, shrink the window
            while (hm.size() > k) {
                char start = s.charAt(i);
                hm.put(start, hm.get(start) - 1);

                // Remove the character if its count reaches zero
                if (hm.get(start) == 0) {
                    hm.remove(start);
                }
                i++;  // Shrink the window from the left
            }

            j++;  // Expand the window
        }

        return ans;
    }
}
