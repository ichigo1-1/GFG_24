//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

// } Driver Code Ends


class Solution
{
	static int[] findSmallestRange(int[][] nums,int n,int k)
	{
	    //add your code here

        int[] vec=new int[k];
        int[] resultrange={-1000000,1000000};
        while(true)
        {
            int minIdx=0;//starting off with 0
            int maxValue=Integer.MIN_VALUE;
            int minValue=Integer.MAX_VALUE;

            for(int i=0;i<k;i++)
            {
                int listindex=i;//gives the list
                int elemindex=vec[i];//gives the index of list in vec as were storing indexes not element
                int element=nums[listindex][elemindex];
                if(element<minValue)
                {
                    minValue=element;
                    minIdx=i;
                }
                //also update max
                maxValue=Math.max(maxValue,element);
            }
            //now check if cur range better or not???
            if(maxValue-minValue<resultrange[1]-resultrange[0])
            {
                resultrange[0]=minValue;
                resultrange[1]=maxValue;
            }
            //now move to the list which has smallest element
            int nextidx=vec[minIdx]+1;
            if(nextidx>=nums[minIdx].length)//agar out of range ho jata h toh break kardo
            {
                break;
            }
            vec[minIdx]=nextidx;
        }
        return resultrange;
	}
}