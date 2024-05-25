//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        ArrayList<Long> res = new ArrayList<>();
        Queue<Long>q=new LinkedList<>();
        int i=0;
        int j=0;
        while(j<N)
        {
            if(A[j]<0)
            {
                q.add(A[j]);
            }
            if(j-i+1==K)
            {
                if(!q.isEmpty())
                {
                    res.add(q.peek());
                }
                else{
                    res.add(0L);
                }
            
            //ab window shift karna hai
            if(A[i]<0 && !q.isEmpty())
            {
                q.poll();
            }
            i++;
            }
            j++;
        }
        long[] longArray = new long[res.size()];
        for (int x = 0; x < res.size(); x++) {
            longArray[x] = res.get(x);
        }
        return longArray;
    }
}