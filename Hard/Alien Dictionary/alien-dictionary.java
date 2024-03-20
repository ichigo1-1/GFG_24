//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    //topological using dfs
    static void dfs(int start,ArrayList<ArrayList<Integer>> adj,int[]vis,Stack<Integer>st)
    {
        vis[start]=1;
        //look for adjacent nodes
        for(int it:adj.get(start))
        {
            if(vis[it]==0)
            {
                dfs(it,adj,vis,st);
            }
        }
        //while going back push to stack;
        st.push(start);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Stack<Integer>st=new Stack<>();
        int []vis=new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,adj,vis,st);
            }
        }
        int[]res=new int[st.size()];
        int i=0;
        while(!st.isEmpty())
        {
            res[i++]=st.pop();
        }
        return res;
    }
    
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        //create a graph to store edges
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<K;i++)
        {
            adj.add(new ArrayList<>());
        }
        //compare strings
        //n-1 beacuse we are comparing pairs so till sec last
        for(int i=0;i<N-1;i++)
        {
            String s1=dict[i];
            String s2=dict[i+1];
            
            //compare till smallest leneght of 2,basic understanding
            int len=Math.min(s1.length(),s2.length());
            //run loop and check for non similar char 
            //then make an edge from s1 char to s2 char 
            //convert it to number by using -'a'
            for(int in=0;in<len;in++)
            {
                if(s1.charAt(in)!=s2.charAt(in))
                {
                    adj.get(s1.charAt(in)-'a').add(s2.charAt(in)-'a');
                    //no need to check further once a non similar char is found as disctionary is ordered based on 1st non similar char
                    break;
                }
            }
            
        }
        //List  to store answers
        int[]top=topoSort(K,adj);
        String ans="";
        for(int it:top)
        {
            ans+=(char)(it + (int)('a'));
        }
        return ans;
        
        
        
    }
}