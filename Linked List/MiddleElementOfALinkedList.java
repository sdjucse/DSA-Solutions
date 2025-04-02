/*
 * Time Complexity: O(N/2)  or O(N/2) ~ O(N).
    Space Complexity : O(1)
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) 
    { 
         this.val = val;
    }
     ListNode(int val, ListNode next) {
         this.val = val; this.next = next; 
        }
    }
public class MiddleElementOfALinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast != null && fast.next != null && slow != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
