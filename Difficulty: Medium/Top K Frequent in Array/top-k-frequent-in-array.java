//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            int[] res = new Solution().topK(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.length; i++) System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] topK(int k, int[] nums) {
        // Code here
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int it:nums)
        {
            hm.put(it,hm.getOrDefault(it,0)+1);
        }
       PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>(
            (a,b)->{
                if(a.getValue().equals(b.getValue()))
                {
                    return b.getKey()-a.getKey();
                }
                return b.getValue()-a.getValue();
            }
        );
        for(Map.Entry entry:hm.entrySet())
        {
            pq.add(entry);
        }
        int[]res=new int[k];
        for(int i=0;i<k;i++)
        {
            res[i]=pq.poll().getKey();
        }
        return res;
    }
}
