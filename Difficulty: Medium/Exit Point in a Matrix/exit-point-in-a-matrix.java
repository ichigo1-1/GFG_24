//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
    int dir = 0;
    int i = 0;
    int j = 0;
    int[] res = new int[2];
    
    while (true) {
        dir = (dir + matrix[i][j]) % 4;
        
        if (dir == 0) { // move right
        matrix[i][j]=0;
            j++;
        } else if (dir == 1) {
               matrix[i][j]=0;// move down
            i++;
        } else if (dir == 2) {
               matrix[i][j]=0;// move left
            j--;
        } else if (dir == 3) { 
               matrix[i][j]=0;// move up
            i--;
        }
        
        // breaking conditions
        if (i < 0) {
            i++;
            break;
        } else if (j < 0) {
            j++;
            break;
        } else if (i >= matrix.length) {
            i--;
            break;
        } else if (j >= matrix[0].length) {
            j--;
            break;
        }
    }
    
    res[0] = i;
    res[1] = j;
    return res;
    }
}