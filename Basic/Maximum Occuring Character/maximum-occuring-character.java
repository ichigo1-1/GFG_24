//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        HashMap<Character,Integer>hm=new HashMap<>();
        for(char ch:line.toCharArray())
        {
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int max=Integer.MIN_VALUE;
        char mfc=line.charAt(0);
		for(Character c:hm.keySet())
		{
			if(hm.get(c)>hm.get(mfc)||(hm.get(c)==hm.get(mfc))&&(c<mfc))
			{
				mfc=c;
			}
		}
		return mfc;
    }
}