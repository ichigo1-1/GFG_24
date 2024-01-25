//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
       public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String str = sc.nextLine();
            Solution ob = new Solution();
            if(ob.sentencePalindrome(str))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    } 
} 
// } Driver Code Ends


class Solution { 

    static boolean sentencePalindrome(String s) { 
        // code here
         s = s.toLowerCase();
        StringBuilder b = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))
            {
                b.append(s.charAt(i));
            }
        }

        int n=b.length()-1;
        for(int i=0;i<b.length()/2;i++)
        {
             if(b.charAt(i)!=b.charAt(n-i))
                return false;
        }
         return true;
    }
}