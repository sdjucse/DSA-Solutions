class Node {
    public int data;
    public Node next;

    // Constructor with both data and next node
    public Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data (assuming next is initially null)
    public Node(int data1) {
        data = data1;
        next = null;
    }
}

public class SinglyLinkedListOperations {
    public static Node insertAtEnd(Node head, int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static Node insertAtBeginning(Node head, int val) {
        Node temp = new Node(val);
        temp.next=head;
        return temp;
    }

    public static Node insertAtMiddle(Node head,int val){
       Node temp= new Node(val);
       if(head==null){
        return temp;
       }
       Node slow=head;
       Node fast=head;
       while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
       }
       temp.next=slow.next;
       slow.next=temp;
       return head;
    }
    public static Node deleteAtBeginning(Node head){
        if(head==null){
            return null;
        }
        return head.next;
    }
    public static Node deleteAtEnd(Node head){
        if(head==null || head.next==null){
            return null;
        }
        while(head.next!=null && head.next.next!=null){
            head=head.next;
        }
        head.next=null;
        return head;
    }
    public static Node deleteAtMiddle(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node slow=head;
       Node fast=head;
       Node prev=null;
       while(fast.next!=null && fast.next.next!=null){
        prev=slow;
        slow=slow.next;
        fast=fast.next.next;
       }
       prev.next=slow.next;
       return head;
    }
    public static int checkifPresent(Node head, int desiredElement) {
        Node temp = head;

        // Traverse the linked list
        while (temp != null) {
            // Check if the current node's data is equal to the desired element
            if (temp.data == desiredElement)
                return 1;  // Return 1 if the element is found

            // Move to the next node
            temp = temp.next;
        }

        return 0;
    }
}
