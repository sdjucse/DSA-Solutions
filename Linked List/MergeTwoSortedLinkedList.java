import java.util.*;

// Node class represents a
// node in a linked list
class Node {
    // Data stored in the node
    int data;

    // Pointer to the next node in the list
    Node next;

    // Constructor with both data and
    // next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as a
    // parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}
public class MergeTwoSortedLinkedList{
    /*
     * Time Complexity: O((N1+N2)log(N1+N2)) + O(N1+N2) + O(N1+N2)
     * Space Complexity: O(N1+N2)
     */
    static Node convertArrToLinkedList(ArrayList<Integer> arr) {

        // Create a dummy node to serve
        // as the head of the linked list
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        // Iterate through the array and
        // create nodes with array elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the array element
            temp.next = new Node(arr.get(i));
            // Move the temporary pointer to the newly created node
            temp = temp.next;
        }
        // Return the linked list starting
        // from the next of the dummy node
        return dummyNode.next;
    }

    // Function to merge two sorted linked lists
    static Node sortTwoLinkedListsUsingArray(Node list1, Node list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp1 = list1;
        Node temp2 = list2;

        // Storing elements of both lists into an array
        
        // Add elements from list1 to the array
        while (temp1 != null) {
            arr.add(temp1.data);
            // Move to the next node in list1
            temp1 = temp1.next;
        }

        // Add elements from list2 to the array
        while (temp2 != null) {
            arr.add(temp2.data);
            // Move to the next node in list2
            temp2 = temp2.next;
        }

        // Sorting the array in ascending order
        Collections.sort(arr);

        // Converting the sorted array
        // back to a linked list
        Node head = convertArrToLinkedList(arr);

        // Return the head of the
        // merged sorted linked list
        return head;
    }
    /*
     * Time Complexity: O(N1+N2)
     * Space Complexity: O(1)
     */
    static Node sortTwoLinkedLists(Node list1, Node list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.data>list2.data){
            Node temp=list1;
            list1=list2;
            list2=temp;
        }
        Node res=list1; 

        while(list1!=null && list2!=null){
            Node temp=null;
            while(list1!=null && list1.data<=list2.data){
                temp=list1;
                list1=list1.next;
            }
            temp.next=list2;
            // Swap the lists
            Node t=list1;
            list1=list2;
            list2=t;
        }
        return res;

    }

}