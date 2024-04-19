//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int nums[], int n, int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
       
        //store the next greater element for each el
        Stack<Integer>st=new Stack<>();
        int[]nge=new int[nums.length];
        nge[nums.length-1]=nums.length;
        st.push(nums.length-1);

        for(int i=nums.length-2;i>=0;i--)
        {
            while(!st.isEmpty() && nums[i]>=nums[st.peek()])//chota logko hatate raho
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                nge[i]=nums.length;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(i);
        }

        //now run loop and see
        int ind=0;
        for(int i=0;i<=nums.length-k;++i)
        {
            // int j=i;//to jump to nge
        int j=i;
            while(nge[j]<i+k)
            {
                j=nge[j];
            }
        
            res.add(nums[j]);
        }

        return res;
    }
}