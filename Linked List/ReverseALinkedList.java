import java.util.Stack;

public class ReverseALinkedList {
    /*
     * Reverse a linked list using stack.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static Node ReverseALinkedListUsingStack(Node head){
        Node temp=head;
        Stack<Integer> stack=new Stack<>();
        while(temp!=null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            temp.data=stack.pop();
            temp=temp.next;
        }
        return head;
    }
    /*
     * Optimal Solution to reverse a linked list.
     * Reverse linked list in place using iterative method.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static Node ReverseALinkedListUsingIterativeApproach(Node head){
        Node dummy=null;
        Node ptr=head;
        while(ptr!=null){
            Node nex=ptr.next;
            ptr.next=dummy;
            dummy=ptr;
            ptr=nex;
        }
        return dummy;
    }
}
