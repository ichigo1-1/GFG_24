//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(n, arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(int n, String[] arr) {
        // code here
        String[]num=new String[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            num[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(num,(a,b)->(b+a).compareTo(a+b));
        if(num[0].equals("0"))
        {
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(String s:num)
        {
            sb.append(s);
        }
        return sb.toString();
    }
}