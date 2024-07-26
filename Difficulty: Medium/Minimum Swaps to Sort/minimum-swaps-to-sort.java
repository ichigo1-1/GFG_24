//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int count=0;
        int[]arr=nums.clone();
        Arrays.sort(arr);
        Map<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            hm.put(arr[i],i);
        }
        for(int i=0;i<nums.length;i++)
        {
            //swap till the current el is not in its correct index
            while(hm.get(nums[i])!=i)
            {
                count++;
                int temp=nums[i];
                nums[i]=nums[hm.get(temp)];
                nums[hm.get(temp)]=temp;
            }
        }
        return count;
    }
    
}