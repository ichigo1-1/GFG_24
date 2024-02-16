//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            
            String s = sc.next();
            
            int answer = new Solution().isRotatedPalindrome(s);
    		System.out.println(answer);
        }
        
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    int isRotatedPalindrome(String s) {
        // Iterate through each character in the string and rotate the string
        for (int i = 0; i < s.length(); i++) {
            // Rotate the string by one position
            s = s.substring(1) + s.charAt(0);
            // Check if the rotated string is a palindrome
            if (isPalindrome(s)) {
                return 1; // If a palindrome is found, return 1
            }
        }
        return 0; // If no palindrome is found after all rotations, return 0
    }

    // Function to check if a string is a palindrome
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        // Iterate through the string from both ends
        while (left < right) {
            // If characters at current positions don't match, return false
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++; // Move left pointer to the right
            right--; // Move right pointer to the left
        }
        return true; // If the loop completes, the string is a palindrome
    }
}
