//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to find the first non-repeating character in a string using brute force.
    static char nonrepeatingCharacter(String S) {
        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            boolean foundDuplicate = false;
            
            // Check if the current character appears elsewhere in the string
            for (int j = 0; j < S.length(); j++) {
                if (i != j && currentChar == S.charAt(j)) {
                    foundDuplicate = true;
                    break;
                }
            }
            
            // If the current character is non-repeating, return it
            if (!foundDuplicate) {
                return currentChar;
            }
        }
        
        // If no non-repeating character is found, return '$'
        return '$';
    }
}

