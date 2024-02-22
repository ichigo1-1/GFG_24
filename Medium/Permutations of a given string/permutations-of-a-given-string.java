//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends




class Solution {
    public List<String> find_permutation(String S) {
        List<String> ans = new ArrayList<>();
        char[] arr = S.toCharArray();
        String ds = "";
        boolean[] freq = new boolean[arr.length];
        backtrack(ans, ds, freq, arr);
        Set<String>res=new HashSet<>();
        res.addAll(ans);
        List<String> answer = new ArrayList<>();
        answer.addAll(res);
        Collections.sort(answer);
        return answer;
    }

    public void backtrack(List<String> ans, String ds, boolean[] freq, char[] arr) {
        if (ds.length() == arr.length) {
            ans.add(ds);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                ds += arr[i];
                freq[i] = true;
                backtrack(ans, ds, freq, arr);
                ds = ds.substring(0, ds.length() - 1); // Backtrack by removing the last character added
                freq[i] = false;
            }
        }
    }
}

