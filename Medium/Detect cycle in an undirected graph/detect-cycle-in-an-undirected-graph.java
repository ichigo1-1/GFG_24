//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
     public boolean dfs(int start,int parent,ArrayList<ArrayList<Integer>> adj,int[]vis)
    {
        vis[start]=1;
        //now look for adjacent nodes;
        for(int it:adj.get(start))
        {
            if(vis[it]==0)
            {
                if(dfs(it,start,adj,vis)==true)
                {
                    return true;
                }
            }
            //agar visited hai and is visited by someone which is not the parent
            else if(it!=parent){
                
                
                    return true;
                    
                }
            
        }
        
        //while going back remove from path and return false

        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         int[]vis=new int[V];
       
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,-1,adj,vis)==true)
                {
                    return true;
                }
            }
        }
        return false;
        
    }
}