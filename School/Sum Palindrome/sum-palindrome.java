//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumPalindrome(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long rev(long num) {
        long reversed = 0;
        while (num > 0) {
            long digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    static boolean isPalindrome(long num) {
        long original = num;
        long reversed = rev(num);
        return original == reversed;
    }

    static long isSumPalindrome(long n) {
        for (int count = 0; count < 5; count++) {
            if(rev(n)==n)
            {
                return n;
            }
            long reversed = rev(n);
            long sum = n + reversed;

            if (isPalindrome(sum)) {
                return sum;
            }

            n = sum;
        }
        return -1;
    }
}
