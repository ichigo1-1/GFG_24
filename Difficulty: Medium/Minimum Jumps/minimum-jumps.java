//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] nums) {
    // Initialize the number of jumps, left and right boundaries of the current range
    int jumps = 0;
    int l = 0;
    int r = 0;

    // Traverse the array until we reach the last index
    while (r < nums.length - 1) {
        int farthest = 0;

        // Check all positions in the current range [l, r] to see how far we can jump
        for (int i = l; i <= r; i++) {
            farthest = Math.max(farthest, i + nums[i]);
        }

        // If we can't go further than the current range, the last index is unreachable
        if (farthest <= r) {
            return -1;
        }

        // Update the range and increase the jump count
        jumps++;
        l = r + 1; // Move to the next range
        r = farthest; // Expand the range to the farthest reachable point
    }

    return jumps;
}

}