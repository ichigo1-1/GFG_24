//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
        // Create a temporary array to store merged elements
        int []temp = new int[r - l + 1];
        int low = l;
        int high = m + 1;
        int index = 0;

        // Merge the two subarrays
        while (low <= m && high <= r)
        {
            if (arr[low] <= arr[high])
            {
                temp[index++] = arr[low++];
            }
            else
            {
                temp[index++] = arr[high++];
            }
        }

        // Copy remaining elements from the left subarray (if any)
        while (low <= m)
        {
            temp[index++] = arr[low++];
        }

        // Copy remaining elements from the right subarray (if any)
        while (high <= r)
        {
            temp[index++] = arr[high++];
        }

        // Copy the merged elements back to the original array
        for (int i = 0; i < temp.length; i++)
        {
            arr[l + i] = temp[i]; // Correct index calculation
        }
    }

    void sort(int[] arr, int l, int r)
    {
        // Base case: when the subarray has one or no elements
        if (l >= r)
        {
            return;
        }

        // Find the middle point
        int mid = (l + r) / 2;

        // Sort the first half and the second half
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // Merge the sorted halves
        merge(arr, l, mid, r);
    }

    void mergeSort(int arr[], int l, int r)
    {
        // Call the recursive sort function to sort the entire array
        sort(arr, l, r);
    }
}
