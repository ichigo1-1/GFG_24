//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void dfs(int row,int col,ArrayList<String>vec,boolean[][]vis,int[][]grid,int ro,int co)
    {
        vis[row][col]=true;
        vec.add(toString(row-ro,col-co));
        int n=grid.length;
        int m=grid[0].length;
        int[]drow={-1,0,1,0};
        int[]dcol={0,-1,0,1};
        for(int i=0;i<4;i++)
        {
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==false && grid[nrow][ncol]==1)
            {
                dfs(nrow,ncol,vec,vis,grid,ro,co);
            }
        }
    }
    private String toString(int r,int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        HashSet<ArrayList<String>>st=new HashSet<>();
        boolean[][]vis=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==false && grid[i][j]==1)
                {
                    ArrayList<String>vec=new ArrayList<>();
                    dfs(i,j,vec,vis,grid,i,j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
}
