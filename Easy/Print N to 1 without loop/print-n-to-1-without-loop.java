//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printNos(N);
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {

    public void printNos(int N) {
        int[] res = new int[N];
        rec(N, res, 0);
        for (int it : res) {
            System.out.print(it + " ");
        }
    }

    static void rec(int N, int[] res, int index) {
        if (N == 0) {
            return;
        }
        res[index] = N;
        rec(N - 1, res, index + 1);
    }
}