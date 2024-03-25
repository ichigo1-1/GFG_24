//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static void removeDuplicates(ArrayList<ArrayList<Integer>> arrayList) {
        // Create a HashSet to store unique ArrayList<Integer>
        HashSet<ArrayList<Integer>> set = new HashSet<>(arrayList);

        // Clear the original arrayList
        arrayList.clear();

        // Add all elements from the set back to the arrayList
        arrayList.addAll(set);
    }

    static void rec(int i, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> arr, int n, boolean[] freq) {
        if (ds.size() == n) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int in = 0; in < n; in++) {
            if (!freq[in]) {
                freq[in] = true;
                ds.add(arr.get(in));
                rec(in, ds, ans, arr, n, freq);
                ds.remove(ds.size() - 1);
                freq[in] = false;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[n];
        rec(0, ds, ans, arr, n, freq);
        removeDuplicates(ans);
        
        // Sort the ans list before returning
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                int size = Math.min(list1.size(), list2.size());
                for (int i = 0; i < size; i++) {
                    int cmp = Integer.compare(list1.get(i), list2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(list1.size(), list2.size());
            }
        });

        return ans;
    }
}