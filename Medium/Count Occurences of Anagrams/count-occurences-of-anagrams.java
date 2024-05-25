//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean allzeroes(int[]arr)
    {
        for(int it:arr)
        {
            if(it!=0)
            {
                return false;
            }
        }
        return true;
    }

    int search(String pat, String txt) {
        // code here
        // HashMap<Character,Integer>hm=new HashMap<>();
        // for(char ch:pat.toCharArray())
        // {
        //     hm.put(ch,hm.getOrDefault(ch,0)+1);
        // }
        // int count=0;
        // int len=pat.length();
        // //now traverse
        // for (int i = 0; i <= txt.length() - len; i++) {
        // HashMap<Character, Integer> currentMap = new HashMap<>();
        // // Extract the substring
        // String subStr = txt.substring(i, i + len);

        // // Create a frequency map for the current substring
        // for (char ch : subStr.toCharArray()) {
        //     currentMap.put(ch, currentMap.getOrDefault(ch, 0) + 1);
        // }

        // // Check if the frequency map of the current substring matches the pattern's frequency map
        // if (currentMap.equals(hm)) {
        //     count++;
        // }
        
        // }
        // return count;
        
       
        int k=pat.length();
        int[]arr=new int[26];
        //freq update
        for(int i=0;i<k;i++)
        {
            char ch=pat.charAt(i);
            arr[ch-'a']++;
        }
        int n=txt.length();
        int i=0;
        int j=0;
        int count=0;
        while(j<n)
        {
            //remove j's freq
            arr[txt.charAt(j)-'a']--;
            //if size equal hota hai
            if(j-i+1==k)
            {
                if(allzeroes(arr))
                {
                    count++;
                }
                 arr[txt.charAt(i)-'a']++;
                i++;
            }
            //everytime j++;
           
            j++;
        }
        return count;
    }
}