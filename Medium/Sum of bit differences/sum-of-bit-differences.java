//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().sumBitDifferences(arr, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    long sumBitDifferences(int[] arr, int n) {
        // code here
        long ans=0L;
        for(int i=0;i<32;i++)
        {
            long count0=0L;
            long count1=0L;
            for(int j=0;j<n;j++)
            {
                if(((1<<i)&arr[j])==0)
                {
                    count0++;
                }
                else{
                    count1++;
                }
            }
            ans+=count0*count1*2;
        }
        return ans;
        
    }
}