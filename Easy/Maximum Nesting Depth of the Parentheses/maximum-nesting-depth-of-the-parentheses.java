//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        // code here
         int count=0;
        int result=0;
        for(char c:s.toCharArray())
        {
            if(c=='(')
            {
                count++;
                result=Math.max(count,result);
            }
            else if(c==')'){
                count--;
            }
        }
        return result;
    }
}
        
