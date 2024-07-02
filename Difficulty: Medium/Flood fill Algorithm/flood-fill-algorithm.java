//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public void dfs(int sr, int sc, int[][] image, int newColor, boolean[][] vis, int curColor) {
        image[sr][sc] = newColor;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        vis[sr][sc] = true;
        int n = image.length;
        int m = image[0].length;

        for (int k = 0; k < 4; k++) {
            int row = sr + dRow[k];
            int col = sc + dCol[k];  // Corrected this line
            if (row >= 0 && col >= 0 && row < n && col < m && !vis[row][col] && image[row][col] == curColor) {
                dfs(row, col, image, newColor, vis, curColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if (curColor == newColor) return image;  // Added this check to avoid unnecessary DFS calls
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        dfs(sr, sc, image, newColor, vis, curColor);
        return image;
    }
}