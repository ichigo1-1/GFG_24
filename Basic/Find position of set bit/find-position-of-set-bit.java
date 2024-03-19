//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findPosition(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findPosition(int N) {
        // code here
        int count=0;
        int index=0;
        for(int i=0;i<32;i++)
        {
            if(((N&(1<<i)))!=0)
            {
                count++;
                index=i+1;
            }
        }
        if(count==1)
        {
            return index;
        }
        return -1;
    }
};