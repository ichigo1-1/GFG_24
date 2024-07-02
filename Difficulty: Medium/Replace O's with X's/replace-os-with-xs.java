//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int r,int c,boolean[][]vis,char[][]a,int n,int m)
    {
        vis[r][c]=true;
        int[]drow={-1,0,1,0};
        int[]dcol={0,1,0,-1};
        for(int k=0;k<4;k++)
        {
            int nrow=r+drow[k];
            int ncol=c+dcol[k];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==false && a[nrow][ncol]=='O')
            {
                dfs(nrow,ncol,vis,a,n,m);
            }
        }
    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean[][] vis = new boolean[n][m];
        
        // First row and last row
        for (int i = 0; i < m; i++) {
            if (!vis[0][i] && a[0][i] == 'O') {
                dfs(0, i, vis, a, n, m);
            }
            if (!vis[n - 1][i] && a[n - 1][i] == 'O') {
                dfs(n - 1, i, vis, a, n, m);
            }
        }
        
        // First column and last column
        for (int j = 0; j < n; j++) {
            if (!vis[j][0] && a[j][0] == 'O') {
                dfs(j, 0, vis, a, n, m);
            }
            if (!vis[j][m - 1] && a[j][m - 1] == 'O') {
                dfs(j, m - 1, vis, a, n, m);
            }
        }
        //now fil
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(a[i][j]=='O' && vis[i][j]==false)
                {
                    a[i][j]='X';
                }
            }
        }
        return a;
        
    }
}