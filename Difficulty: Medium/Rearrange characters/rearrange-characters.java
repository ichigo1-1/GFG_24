//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends


class Pair {
    char ch;
    int f;

    Pair(char c, int ff) {
        ch = c;
        f = ff;
    }
}

class Solution {
    public static String rearrangeCharacters(String s) {
        // Create a frequency array to count occurrences of each character
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        // Create a max-heap (priority queue) to store characters based on their frequency
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.f - a.f));
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.add(new Pair((char) ('a' + i), map[i]));
            }
        }

        StringBuilder ans = new StringBuilder();
        Pair prev = null; // To hold the previous character

        while (!pq.isEmpty()) {
            Pair current = pq.poll(); // Get the character with the highest frequency
            ans.append(current.ch); // Append current character to result

            // Decrease the frequency of the current character
            current.f--;

            // If there was a previous character waiting to be added back
            if (prev != null && prev.f > 0) {
                pq.offer(prev);
            }

            // Update the previous character to the current one
            prev = current;
        }

        // Check if we could successfully rearrange the string
        // If any character remains in `prev` with frequency > 0, it's not possible
        if (prev != null && prev.f > 0) {
            return "-1"; // Not possible to rearrange
        }

        return ans.toString(); // Return the rearranged string
    }
}
