//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int phy[] = new int[n];
    		int chem[] = new int[n];
    		int math[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                {
                    phy[i]=sc.nextInt();
                    chem[i]=sc.nextInt();
                    math[i]=sc.nextInt();
                }
		    
		    Solution ob = new Solution();
		    
		    ob.customSort (phy, chem, math, n);
    		for (int i = 0; i < n; ++i)
    			System.out.println(phy[i]+" " + chem[i] + " " + math[i]);

        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Marks implements Comparable<Marks> {
    int phy, chem, math;

    Marks(int p, int c, int m) {
        phy = p;
        chem = c;
        math = m;
    }

    public int compareTo(Marks o) {
        if (this.phy != o.phy) {
            return this.phy - o.phy;
        } else if (this.chem != o.chem) {
            return o.chem - this.chem;
        } else {
            return this.math - o.math;
        }
    }
}

class Solution {
    public void customSort(int phy[], int chem[], int math[], int N) {
        int n = phy.length;
        Marks[] m = new Marks[n];

        for (int i = 0; i < n; i++) {
            m[i] = new Marks(phy[i], chem[i], math[i]);
        }

        // Sort the Marks array
        Arrays.sort(m);

        // Update the original arrays
        for (int i = 0; i < n; i++) {
            phy[i] = m[i].phy;
            chem[i] = m[i].chem;
            math[i] = m[i].math;
        }
    }
}
