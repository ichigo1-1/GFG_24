//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node reverse(Node head)
	{
		Node prev=null;
		Node temp=head;
		while(temp!=null)
		{
			 Node front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
		}
		return prev;
	}
	public static Node addOne(Node head) {
		// Write your code here.
		head=reverse(head);
		int carry=1;
		Node temp=head;
		int sum=0;
		while(temp!=null)
		{
			temp.data=temp.data+carry;
			if(temp.data<10)
			{
				carry=0;
				break;
			}
			else{
				temp.data=0;
				carry=1;
			}
			temp=temp.next;

		}
		if(carry==1)
		{
			Node newnode = new Node(1);
			head=reverse(head);
			newnode.next=head;
			return newnode;
		}
		head=reverse(head);
		return head;

	}
}
