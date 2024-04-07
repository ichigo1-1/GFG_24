//{ Driver Code Starts
import java.util.*;
import java.io.*;
class PeakElement{
	public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
			int n=Integer.parseInt(in.readLine().trim());
			int[] a=new int[n];
		    int[] tmp=new int[n];
		    String s[]=in.readLine().trim().split(" ");
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(s[i]);
				tmp[i] = a[i];
			}
		    
		    int f=0;
			int A=(new Solution()).peakElement(tmp,n);
			
			if(A<0 && A>=n)
			    out.println(0);
			else
			{
    			if(n==1 && A==0)
    			    f=1;
    			else if(A==0 && a[0]>=a[1])
    			    f=1;
    			else if(A==n-1 && a[n-1]>=a[n-2])
    			    f=1;
    			else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
    			    f=1;
    			else
    			    f=0;
			    out.println(f);
			}
		}
		out.close();
	}
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    
    int binarysearch(int arr[], int s, int e, int n) {
        while (s <= e) {
            int m = (s+e) / 2;
            
            if (arr[m] >= arr[m - 1] && arr[m] >= arr[m + 1]) {
                return m; 
            }
            else if (arr[m - 1] > arr[m]) {
                e = m - 1;
            }
            else if(arr[m]<arr[m+1]){
                s = m + 1;
            }
        }
        return -1; 
    }
    int peakElement(int arr[], int n)
    {
       int s=0,e=n-1;
      if(n==1){
          return 0;
      }
      if(arr[0]>=arr[1]){
          return s;
      }
       
      if(arr[n-1]>=arr[n-2]){
           
          return e;
      }
       int ans = binarysearch(arr,1,n-2,n);
       
       return ans;
    }
};