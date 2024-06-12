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
            sc.nextLine();
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String str1, String str2) {
        // code here
        int startInd = -1;
    int minLen = Integer.MAX_VALUE;
    
    if (str1.length() < str2.length()) {
        return ""; // Return "-1" if str1 is shorter than str2
    }
    
    // Brute force approach
    for (int i = 0; i < str1.length(); i++) {
        int k = 0;
        for (int j = i; j < str1.length(); j++) {
            if (str1.charAt(j) == str2.charAt(k)) {
                k++;
            }
            if (k == str2.length()) {
                // Found a window containing all characters of str2
                int windowSize = j - i + 1;
                if (windowSize < minLen) {
                    // Update minimum window size and start index
                    minLen = windowSize;
                    startInd = i;
                }
                break; // Break the inner loop, move to the next i
            }
        }
    }
    
    // Return the smallest window or "-1" if no such window exists
    return minLen == Integer.MAX_VALUE ? "" : str1.substring(startInd, startInd + minLen);
}
       
        
}
