//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
         long[] rb = new long[(int) n];
        Stack<Integer> st = new Stack<>();
        st.push((int) (n - 1));

        rb[(int) (n - 1)] = n;

        for (int i = (int) (n - 2); i >= 0; i--) {
            while (!st.isEmpty() && hist[st.peek()] >= hist[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                rb[i] = n;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        Stack<Integer> sto = new Stack<>();
        sto.push(0);
        long[] lb = new long[(int) n];
        lb[0] = -1;

        for (int i = 1; i < n; i++) {
            while (!sto.isEmpty() && hist[sto.peek()] >= hist[i]) {
                sto.pop();
            }
            if (sto.isEmpty()) {
                lb[i] = -1;
            } else {
                lb[i] = sto.peek();
            }
            sto.push(i);
        }

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int width = (int) (rb[i] - lb[i] - 1);
            int height = (int) hist[i];
            long area = (long) height * width;
            if (area > max) {
                max = area;
            }
        }
        return max;
        
    }
        
}



