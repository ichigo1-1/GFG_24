//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Pair implements Comparable<Pair>{
    int start;
    int end;
    Pair(int s,int e)
    {
        start=s;
        end=e;
    }
    
    public int compareTo(Pair o)
    {
        if(this.end!=o.end)
        {
            return this.end-o.end;
        }
        return this.start-o.start;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        Pair[] p = new Pair[n];
        
        // Initialize the Pair array with start and end times
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(start[i], end[i]);
        }
        
        // Sort the meetings by their end time (and by start time if end times are equal)
        Arrays.sort(p);
        
        int count = 1; // We can always perform at least one meeting
        int lastEnd = p[0].end; // Track the end time of the last selected meeting
        
        // Traverse the sorted meetings
        for (int i = 1; i < n; i++) {
            // If the current meeting starts after the last meeting ends, select it
            if (p[i].start > lastEnd) {
                count++;
                lastEnd = p[i].end; // Update the end time to the current meeting's end time
            }
        }
        
        return count;
    }
}
