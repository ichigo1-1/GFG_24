//{ Driver Code Starts
// Initial Template for Java
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
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer>bfs =new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        boolean[]vis=new boolean[V+1];
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty())
        {
            Integer node=q.poll();
            bfs.add(node);
            //visit its neighbors
            for(Integer it:adj.get(node))
            {
                if(vis[it]==false)
                {
                    q.add(it);
                    vis[it]=true;
                }
            }
        }
        return bfs;
    }
}
//space:- o(3n)=o(n)
//time:- o(n)+o(2e(degrees of each node))













//  ArrayList<Integer>bfs =new ArrayList<>();
//         int[]vis=new int[V];
        
//         Queue<Integer>q=new LinkedList<Integer>();
//         q.add(0);
//         vis[0]=1;
        
//         while(!q.isEmpty())
//         {
//             int topel=q.poll();
//             bfs.add(topel);
//             //look for neighbors
//             for(int it:adj.get(topel))
//             {
//                 if(vis[it]==0)
//                 {
//                     vis[it]=1;
//                     q.add(it);
//                 }
//             }
            
//         }
//         return bfs;