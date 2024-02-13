//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Function to reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second) {
        // Reverse both input linked lists
        first = reverse(first);
        second = reverse(second);

        // Initialize dummy node for the result
        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;

        // Traverse both reversed linked lists simultaneously
        while (first != null || second != null) {
            // Calculate sum of current digits along with carry
            int sum = carry;
            if (first != null) {
                sum += first.data;
                first = first.next;
            }
            if (second != null) {
                sum += second.data;
                second = second.next;
            }

            // Update carry and create new node with the sum
            carry = sum / 10;
            sum %= 10;
            current.next = new Node(sum);
            current = current.next;
        }

        // Handle remaining carry
        if (carry > 0) {
            current.next = new Node(carry);
        }

        // Reverse the result linked list
        dummy.next = reverse(dummy.next);

        // Return the next node of dummy, which is the head of the result list
        return dummy.next;
    }
}
