//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isSafe(int row, int col, char[][] board, int n) {
        int duprow = row;
        int dupcol = col;

        // Check upper diagonal on the left side
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        // Check the left side
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = duprow;
        col = dupcol;

        // Check lower diagonal on the left side
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    static void solve(int col, char[][] board, int n, ArrayList<ArrayList<Integer>> ans) {
        // Base case: If all queens are placed
        if (col == n) {
            ArrayList<Integer> ls = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'Q') {
                        ls.add(j + 1); // Adding the row position (1-based index)
                    }
                }
            }
            ans.add(ls);
            return;
        }

        // Iterate through each row in the current column
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, board, n)) {
                board[i][col] = 'Q'; // Place the queen
                solve(col + 1, board, n, ans); // Recur to place the rest of the queens
                board[i][col] = '.'; // Backtrack and remove the queen
            }
        }
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solve(0, board, n, ans);
        Collections.sort(ans, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });
        return ans;
    }
}