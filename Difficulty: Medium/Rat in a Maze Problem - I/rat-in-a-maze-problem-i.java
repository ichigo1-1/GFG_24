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
    public static void backtrack(int i,int j,ArrayList<String>ans,int[][]arr,int n,String move,int[][]vis)
    {
        //base case
        if(i==n-1 && j==n-1)
        {
          
            ans.add(move);
            return;
        }
        //downward
        if(i+1<n && arr[i+1][j]==1 && vis[i+1][j]==0)
        {
            vis[i][j]=1;
            backtrack(i+1,j,ans,arr,n,move+"D",vis);
            //remove added node
            vis[i][j]=0;
        }
        
        //left
        if(j-1>=0 && arr[i][j-1]==1 && vis[i][j-1]==0)
        {
            vis[i][j]=1;
            backtrack(i,j-1,ans,arr,n,move +"L",vis);
            //remove added node
            vis[i][j]=0;
        }
        
        //right
        if(j+1<n && arr[i][j+1]==1 && vis[i][j+1]==0)
        {
            vis[i][j]=1;
            backtrack(i,j+1,ans,arr,n,move + 'R',vis);
            //remove added node
            vis[i][j]=0;
        }
        
        //upward
        if(i-1>=0 && arr[i-1][j]==1 && vis[i-1][j]==0)
        {
            vis[i][j]=1;
            backtrack(i-1,j,ans,arr,n,move + 'U',vis);
            //remove added node
            vis[i][j]=0;
        }
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String>ans=new ArrayList<>();
        int[][]vis=new int[n][n];
        String move="";
        //spl case 
        //if start is 0 ans=-1;
        if(m[0][0]==1)
            backtrack(0,0,ans,m,n,move,vis);
        else{
            return new ArrayList<String>();
        }    
        return ans;
    }
}