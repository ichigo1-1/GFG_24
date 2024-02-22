//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    private static void backtrack(int i, int j, int[][] m, int n, ArrayList<String> ans, String move, boolean[][] visited) {
        if (i == n - 1 && j == n - 1) {
            ans.add(move);
            return;
        }

        // downward
        if (i + 1 < n && !visited[i + 1][j] && m[i + 1][j] == 1) {
            visited[i][j] = true;
            backtrack(i + 1, j, m, n, ans, move + 'D', visited);
            visited[i][j] = false;
        }

        // right 
        if (j + 1 < n && !visited[i][j + 1] && m[i][j + 1] == 1) {
            visited[i][j] = true;
            backtrack(i, j + 1, m, n, ans, move + 'R', visited);
            visited[i][j] = false;
        }

        // left
        if (j - 1 >= 0 && !visited[i][j - 1] && m[i][j - 1] == 1) {
            visited[i][j] = true;
            backtrack(i, j - 1, m, n, ans, move + 'L', visited);
            visited[i][j] = false;
        }

        // upward
        if (i - 1 >= 0 && !visited[i - 1][j] && m[i - 1][j] == 1) {
            visited[i][j] = true;
            backtrack(i - 1, j, m, n, ans, move + 'U', visited);
            visited[i][j] = false;
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        if (m[0][0] == 1) {
            backtrack(0, 0, m, n, ans, "", visited);
        }
        return ans;
    }
}