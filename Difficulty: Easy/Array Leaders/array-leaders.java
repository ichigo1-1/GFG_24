//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {

            // input size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // inserting elements in the array
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            StringBuffer str = new StringBuffer();
            ArrayList<Integer> res = new ArrayList<Integer>();

            // calling leaders() function
            res = obj.leaders(n, arr);

            for (int i = 0; i < res.size(); i++) {
                ot.print(res.get(i) + " ");
            }

            ot.println();
        }
        ot.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
        // Your code here
       ArrayList<Integer> ar = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        // The last element is always a leader
        st.push(arr[n - 1]);

        // Traverse the array from the second last element to the start
        for (int i = n - 2; i >= 0; i--) {
            // If the current element is greater than or equal to the top of the stack
            if (arr[i] >= st.peek()) {
                st.push(arr[i]); // It is a leader
            }
        }
        // Collect leaders from the stack and add them to the result list
        while (!st.isEmpty()) {
            ar.add(st.pop());
        }

        // The leaders are added in reverse order, so no need to reverse again
        return ar;
    }
}
