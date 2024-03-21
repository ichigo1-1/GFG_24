//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




class meeting{
    int start,end,pos;
    meeting(int start,int end,int pos)
    {
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}
class meetingcomparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting m1,meeting m2)
    {
        if(m1.end<m2.end)
        {
            return -1;
        }
        else if(m1.end>m2.end)
        {
            return 1;
        }
        else if(m1.pos<m2.pos)
        {
            return -1;
        }
        return 1;
    }
}
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<meeting>meet=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            meet.add(new meeting(start[i],end[i],i+1)); 
        }
        meetingcomparator mc=new meetingcomparator();
        //sort it
        Collections.sort(meet,mc);
        //ans to store
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(meet.get(0).pos);
        
        //get its limit
        int limit=meet.get(0).end;
        //start from 1
        for(int i=1;i<n;i++)
        {
            if(meet.get(i).start>limit)
            {
                ans.add(meet.get(i).pos);
                limit=meet.get(i).end;
            }
        }
        return ans.size();
        
        
    }
}