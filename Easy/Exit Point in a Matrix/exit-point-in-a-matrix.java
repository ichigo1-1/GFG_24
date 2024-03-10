//{ Driver Code Starts
//Initial Template for Java

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
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] FindExitPoint(int[][] matrix)
    {
        // code here
        int dir=0;
        int i=0;
        int j=0;
        while(true)
        {
            dir=(dir+matrix[i][j])%4;// as wapas north me aanse 0 wala case hi
            if(dir==0)
            {
                matrix[i][j]=0;
                
                j++;
                
            }
            else if(dir==1)
            
            {
                matrix[i][j]=0;
                i++;
               
            }
            else if(dir==2)
            {
                matrix[i][j]=0;
                j--;
                
            }
            else if(dir==3)
            {
                matrix[i][j]=0;
                i--;
            }
            if(i<0)
            {
                i++;
                break;
              
            }
            if(j<0)
            {
                j++;
                break;
                
            }
            if(i==matrix.length)
            {
                i--;
                break;
            }
            if(j==matrix[0].length)
            {
                j--;
                break;
            }
        }
        return new int[]{i,j};
        
        
        
    }
}