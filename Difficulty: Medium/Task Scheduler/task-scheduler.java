//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            char a[] = new char[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.next().charAt(0);
            }
            Solution obj = new Solution();
            int ans = obj.leastInterval(n, k, a);
            System.out.println(ans);
        }
    }
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int leastInterval(int N, int n, char tasks[]) {
        // code here
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        int[]arr=new int[26];
        for(char ch:tasks)
        {
            arr[ch-'A']++;
        }
        for(int it:arr)
        {
            if(it>0)
                pq.add(it);
        }
        int time=0;
        while(!pq.isEmpty())
        {
            int cycle=n+1;
            List<Integer>temp=new ArrayList<>();
            for(int i=1;i<=cycle;i++)
            {
                if(!pq.isEmpty())
                {
                    int freq=pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }
            for(int it:temp)
            {
                if(it>0)
                {
                    pq.add(it);
                }
            }
            if(pq.isEmpty())
            {
                time+=temp.size();
            }
            else{
                time+=n+1;
            }
        }
        return time;
    }
}
