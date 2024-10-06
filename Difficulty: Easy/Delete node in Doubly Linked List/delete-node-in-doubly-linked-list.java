//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}

public class Main {
    // Function to insert a node at the end of the Doubly Linked List
    public static void push(Node tail, int new_data) {
        Node newNode = new Node(new_data);
        newNode.next = null;
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }
    }

    // Function to print nodes in a given doubly linked list
    public static void printList(Node head) {
        if (head == null) {
            return;
        }
        if (!verify(head)) {
            return;
        }
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main driver function
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] arr = br.readLine().trim().split(" ");

            Node head = new Node(Integer.parseInt(arr[0]));
            Node tail = head;

            for (int i = 1; i < arr.length; i++) {
                push(tail, Integer.parseInt(arr[i]));
                tail = tail.next;
            }
            int x = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            head = obj.deleteNode(head, x);
            printList(head);
        }
    }

    // Verifying the doubly linked list
    public static boolean verify(Node head) {
        int forwardLength = 0;
        int backwardLength = 0;

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
            forwardLength++;
        }

        while (temp.prev != null) {
            temp = temp.prev;
            backwardLength++;
        }

        return forwardLength == backwardLength;
    }
}

// } Driver Code Ends


/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        // Edge case: if the list is empty or has only one node
        if (head == null || (head.next == null && x == 1)) {
            return null;
        }

        int count = 1;
        Node temp = head;

        // Traverse the list to find the x-th node
        while (temp != null && count < x) {
            temp = temp.next;
            count++;
        }

        // If temp is null, the position x is out of bounds, return the original head
        if (temp == null) {
            return head;
        }

        Node prev = temp.prev;
        Node front = temp.next;

        // Handle 3 cases:
        // Case 1: The node is the only node in the list (already handled by the earlier return null)

        // Case 2: Deleting the head node
        if (prev == null) {
            head = head.next; // Move head to the next node
            if (head != null) { // If the new head exists, set its prev to null
                head.prev = null;
            }
        }
        // Case 3: Deleting the last node
        else if (front == null) {
            prev.next = null;
        }
        // Case 4: Deleting a middle node
        else {
            prev.next = front;
            front.prev = prev;
        }

        return head;  // Return the updated head
    }
}
