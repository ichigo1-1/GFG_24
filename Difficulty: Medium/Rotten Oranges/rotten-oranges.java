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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int row,col,time;
    Pair(int r,int c,int t)
    {
        row=r;
        col=c;
        time=t;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        
        int n=grid.length;
        int m=grid[0].length;
        int[][]vis=new int[n][m];
        Queue<Pair>q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                     vis[i][j]=2;
                     q.add(new Pair(i,j,0));
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        //now queue is enqued with the rotten oramges
        int time=0;
        int []drow={-1,0,1,0};
        int[]dcol={0,1,0,-1};
        int count=0;

        while(!q.isEmpty())
        {
          
            int row=q.peek().row;
            int col=q.peek().col;
            int t=q.peek().time;
            time=Math.max(time,t);
            q.remove();
            for(int i=0;i<4;i++)
            {
                int r=row+drow[i];
                int c=col+dcol[i];
                if(r>=0 && c>=0 && r<n && c<m && vis[r][c]==0 && grid[r][c]==1)
                {
                    q.add(new Pair(r,c,t+1));
                    vis[r][c]=2;
                    count++;
                }
            }
        }
        if(count!=fresh)
        {
            return -1;
        }
        return time;
        
    }
}