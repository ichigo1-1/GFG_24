//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			int N = sc.nextInt();
			Solution obj = new Solution();
			obj.toBinary(N);
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	void toBinary(int N) {
		//Write your code here
// 		int rem = 0 , i = 0;
//         ArrayList<Integer> arr = new ArrayList<>();
//         while(N > 0){
//             rem = N%2;
//             arr.add(rem);
//             N = N/2;
//         }
        
//         for(int j = arr.size()-1 ; j >= 0 ; j--){
//             System.out.print(arr.get(j));
//         }
int rem=0;
int i=0;
ArrayList<Integer>arr=new ArrayList<>();
while(N>0)
{
    rem=N%2;
    arr.add(rem);
    N/=2;
}
for(int j=arr.size()-1;j>=0;j--)
{
    System.out.print(arr.get(j));
}
    }
	}
