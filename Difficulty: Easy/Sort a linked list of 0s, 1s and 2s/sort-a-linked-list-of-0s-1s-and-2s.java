//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        Node zerohead=new Node(-1);
        Node onehead=new Node(-1);
        Node twohead=new Node(-1);
        Node zero=zerohead;
        Node one=onehead;
        Node two=twohead;
        
        Node temp=head;
        while(temp!=null)
        {
            if(temp.data==0)
            {
                zero.next=temp;
                zero=temp;
            }
            else if(temp.data==1)
            {
                one.next=temp;
                one=temp;
            }
            else{
                two.next=temp;
                two=temp;
            }
            temp=temp.next;
        }
        //now connect
        zero.next = (onehead.next != null) ? onehead.next : twohead.next; // Connect 0's list to 1's list if available, else to 2's list
        one.next = twohead.next; // Connect 1's list to 2's list
        two.next = null; // Terminate the 2's list to avoid cycles

        // Return the head of the new list (starting from zerohead, but skipping the dummy node)
        return zerohead.next != null ? zerohead.next : (onehead.next != null ? onehead.next : twohead.next);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends