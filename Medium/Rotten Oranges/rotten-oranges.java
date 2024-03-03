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


class Pair
{
    int r;
    int c;
    int tm;
    Pair(int r,int c,int tm)
    {
        this.r=r;
        this.c=c;
        this.tm=tm;
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
        int drow[]={1,-1,0,0};
        int dcol[]={0,0,-1,1};
        
        Queue<Pair>q=new LinkedList<Pair>();
        int[][]vis=new int[n][m];
        int count=0;
        int countfresh=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                if(grid[i][j]==0)
                {
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)
                {
                    countfresh++;
                }
            }
        }
        //now popping time
        int mintime=0;
        
        while(!q.isEmpty())
        {
            int ro=q.peek().r;
            int co=q.peek().c;
            int t=q.peek().tm;
            mintime=Math.max(t,mintime);
            q.poll();
            
            //check for neighbors
            for(int i=0;i<4;i++)
            {
                int nr=ro+drow[i];
                int nc=co+dcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1)
                {
                    q.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    count++;
                }
            }
        }
        if(count!=countfresh)
        {
            return -1;
        }
        else{
            return mintime;
        }
        
        
    }
}