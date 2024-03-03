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


class Solution
{
    public void dfs(int row,int col,int[][]ans,int inicol,int[] drow,int[] dcol,int newcol,int[][]img)
    {
        //mark new color
        ans[row][col]=newcol;
        int n=img.length;
        int m=img[0].length;
        //check neighbour
        for(int i=0;i<4;i++)
        {
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            
            if(nrow<n && nrow>=0 && ncol>=0 && ncol<m && img[nrow][ncol]==inicol && ans[nrow][ncol]!=newcol)
            {
                dfs(nrow,ncol,ans,inicol,drow,dcol,newcol,img);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        
        int[][]ans=image;
        
        int inicol=image[sr][sc];
        
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        
        dfs(sr,sc,ans,inicol,drow,dcol,newColor,image);
        return ans;
        
    }
}