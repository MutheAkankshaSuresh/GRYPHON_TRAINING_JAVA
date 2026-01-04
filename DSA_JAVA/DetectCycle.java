// Node class represents a single element of the linked list
class node {
    int val;       // Value stored in the node
    node next;     // Reference to the next node in the list

    // Constructor to create a new node with a given value
    node(int val) {
        this.val = val;
        this.next = null;  // Initially, next is null
    }
}

// LinkedList class manages the linked list
class LinkedList {
    node head;  // Head points to the first node of the linked list

    // Method to add a new value at the end of the linked list
    void add(int val) {
        node n1 = new node(val);  // Create a new node with the given value

        // If the list is empty, set the new node as the head
        if (head == null) {
            head = n1;
        } 
        // If the list is not empty, traverse to the last node and attach the new node
        else {
            node temp = head;  // Start from the head
            while (temp.next != null) {  // Traverse until the last node
                temp = temp.next;
            }
            temp.next = n1;  // Link the new node at the end
        }
    }

    // Method to print all the values in the linked list
    void print() {
        node temp = head;  // Start from the head
        while (temp != null) {  // Traverse until the end of the list
            System.out.println(temp.val);  // Print current node's value
            temp = temp.next;              // Move to next node
        }
    }
}

// Main class to test the linked list
public class DetectCycle {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();  // Create a new linked list

        // Add elements to the linked list
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);
        l1.add(50);
        l1.add(60);

        System.out.println("The data is :");
        l1.print();  // Print all elements of the list
    }
}
