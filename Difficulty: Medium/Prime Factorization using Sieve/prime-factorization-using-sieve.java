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
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {}

    static List<Integer> findPrimeFactors(int N) {
        // code here
        int[] spf = new int[N + 1];  // spf[i] will store the smallest prime factor of i
        
        // Initialize spf for every number to itself
        for (int i = 1; i <= N; i++) {
            spf[i] = i;
        }

        // Start the sieve to calculate SPF for every number
        for (int i = 2; i * i <= N; i++) {
            if (spf[i] == i) { // i is prime
                // Mark all multiples of i with i as the smallest prime factor
                for (int j = i * i; j <= N; j += i) {
                    // If spf[j] is still equal to j, update it with i (the smaller prime factor)
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        List<Integer> primeFactors = new ArrayList<>();
        // Find the prime factors of N
        while (N != 1) {
            primeFactors.add(spf[N]); // Add the smallest prime factor of N
            N /= spf[N]; // Divide N by its smallest prime factor
        }

        return primeFactors;
    }
}
