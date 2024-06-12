//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
   public static String smallestWindow(String s, String p) {
    int n = s.length();

    if (p.length() > n) {
        return "-1";
    }

    Map<Character, Integer> mp = new HashMap<>();

    // Store character frequencies of string p
    for (char ch : p.toCharArray()) {
        mp.put(ch, mp.getOrDefault(ch, 0) + 1);
    }

    int requiredCount = p.length();
    int i = 0, j = 0;

    int minWindowSize = Integer.MAX_VALUE;
    int start_i = -1;

    // Traverse the string s
    while (j < n) {
        char ch = s.charAt(j);

        if (mp.containsKey(ch) && mp.get(ch) > 0) {
            requiredCount--;
        }

        mp.put(ch, mp.getOrDefault(ch, 0) - 1);

        // Try to shrink the window until it's no longer valid
        while (requiredCount == 0) {
            int currWindowSize = j - i + 1;

            if (minWindowSize > currWindowSize) {
                minWindowSize = currWindowSize;
                start_i = i;
            }

            char startChar = s.charAt(i);
            mp.put(startChar, mp.getOrDefault(startChar, 0) + 1);

            if (mp.containsKey(startChar) && mp.get(startChar) > 0) {
                requiredCount++;
            }

            i++;
        }

        j++;
    }

    return minWindowSize == Integer.MAX_VALUE ? "-1" : s.substring(start_i, start_i + minWindowSize);
}

}