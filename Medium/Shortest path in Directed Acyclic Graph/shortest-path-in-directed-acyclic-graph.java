//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    public void topoSort(int start, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
        vis[start] = 1;
        // Travel the adjacent nodes
        for (int i = 0; i < adj.get(start).size(); i++) {
            int v = adj.get(start).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, vis, st, adj);
            }
        }
        st.add(start);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Adding connects in adj
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // Initialize it
        for (int i = 0; i < N; i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        // Now build connections
        for (int i = 0; i < M; i++) {
            int first = edges[i][0];
            int sec = edges[i][1];
            int third = edges[i][2];
            adj.get(first).add(new Pair(sec, third));
        }
        // Find the topo sort
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        // For all components
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, vis, st, adj);
            }
        }
        
        // Step 2: Distance
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE; // Infinity
        }
        // If source is given, distance[src] = 0
        distance[0] = 0;
        
        while (!st.isEmpty()) {
            int peek = st.pop();
            if (distance[peek] != Integer.MAX_VALUE) {
                for (int i = 0; i < adj.get(peek).size(); i++) {
                    int v = adj.get(peek).get(i).first;
                    int w = adj.get(peek).get(i).second;
                    
                    // Update distance if the new path is shorter
                    if (distance[peek] + w < distance[v]) {
                        distance[v] = distance[peek] + w;
                    }
                }
            }
        }
        
        // Convert unreachable nodes to -1
        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        
        return distance;
    }
}
