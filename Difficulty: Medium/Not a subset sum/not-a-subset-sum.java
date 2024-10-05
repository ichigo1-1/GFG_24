//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");
            int[] arr = new int[inputArr.length];
            for (int i = 0; i < inputArr.length; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }

            Solution ob = new Solution();
            long ans = ob.findSmallest(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public long findSmallest(int[] arr) {
        // Your code goes here
           long smallest = 1; // Step 2: Initialize smallest to 1
        
        // Step 3: Iterate through the sorted array
        for (int num : arr) {
            if (num > smallest) {
                // If the current number is greater than smallest,
                // we cannot form smallest using the previous numbers
                break;
            }
            smallest += num; // If num <= smallest, update smallest
        }
        
        // Step 4: Return the result
        return smallest;
    }
        
}
