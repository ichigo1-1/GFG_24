//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {

    public boolean checkSorted(List<Integer> arr) {
        // code here
        int swaps=0;
        int n=arr.size();
        List<Integer>ls=new ArrayList<>(arr);
        for(int i=0;i<n;i++)
        {
            if(arr.get(i)!=i+1)
            {
               int correctPos = arr.get(i) - 1;  // Find the correct position for arr.get(i)
        
        // Swap arr[i] with the element at its correct position
        int temp = arr.get(correctPos);
        arr.set(correctPos, arr.get(i));
        arr.set(i, temp);
        
        swaps++; 
        i--;// Increment the swap count
            }
        }
       if(swaps==0 || swaps==2)
       {
           return true;
       }
       return false;
    }
}