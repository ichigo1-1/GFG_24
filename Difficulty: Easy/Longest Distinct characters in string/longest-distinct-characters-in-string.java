//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        HashSet<Character>s=new HashSet<>();
        int i=0,j=0;
        int n=S.length();
        int max=-1;
        while(j<n)
        {
            char ch=S.charAt(j);
            
            while(s.contains(ch))
            {
                
                s.remove(S.charAt(i));
                i++;
            }
            max=Math.max(max,j-i+1);
            s.add(ch);
            j++;
        }
        return max;
    }
}