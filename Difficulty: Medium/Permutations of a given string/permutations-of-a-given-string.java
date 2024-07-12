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
    public static int fact(int n) {
        int num = 1;
        for (int i = 2; i <= n; i++) {
            num *= i;
        }
        return num;
    }

    public List<String> find_permutation(String S) {
        Set<String> resSet = new HashSet<>();
        int n = S.length();
        int fac = fact(n);

        for (int i = 0; i < fac; i++) {
            StringBuilder sb = new StringBuilder(S);
            StringBuilder permutation = new StringBuilder();
            int temp = i;

            for (int div = n; div > 0; div--) {
                int r = temp % div;
                permutation.append(sb.charAt(r));
                sb.deleteCharAt(r);
                temp /= div;
            }
            resSet.add(permutation.toString());
        }
        List<String> res = new ArrayList<>(resSet);
        Collections.sort(res); // To maintain lexicographical order if needed
        return res;
    }
}
