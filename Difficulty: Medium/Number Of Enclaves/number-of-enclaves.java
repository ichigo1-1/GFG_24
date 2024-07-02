//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void dfs(int r,int c,boolean[][]vis,int[][]a,int n,int m)
    {
        vis[r][c]=true;
        int[]drow={-1,0,1,0};
        int[]dcol={0,1,0,-1};
        for(int k=0;k<4;k++)
        {
            int nrow=r+drow[k];
            int ncol=c+dcol[k];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==false && a[nrow][ncol]==1)
            {
                dfs(nrow,ncol,vis,a,n,m);
            }
        }
    }
    int numberOfEnclaves(int[][] a) {
        // Your code here
        int n=a.length;
        int m=a[0].length;
        boolean[][]vis=new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (!vis[0][i] && a[0][i] == 1) {
                dfs(0, i, vis, a, n, m);
            }
            if (!vis[n - 1][i] && a[n - 1][i] == 1) {
                dfs(n - 1, i, vis, a, n, m);
            }
        }
        
        // First column and last column
        for (int j = 0; j < n; j++) {
            if (!vis[j][0] && a[j][0] == 1) {
                dfs(j, 0, vis, a, n, m);
            }
            if (!vis[j][m - 1] && a[j][m - 1] == 1) {
                dfs(j, m - 1, vis, a, n, m);
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]==1 && vis[i][j]==false)
                {
                    count++;
                }
            }
        }
        return count;
    }
}