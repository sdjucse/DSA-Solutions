class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
public class AddTwoNumbersInALinkedList {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode c1=l1;
            ListNode c2=l2;
            ListNode sentinel=new ListNode(0);
            ListNode d=sentinel;
            int s=0;
            while(c1!=null || c2!=null)
            {
                s/=10;
                if(c1!=null)
                {
                    s+=c1.val;
                    c1=c1.next;
                }
                if(c2!=null)
                {
                    s+=c2.val;
                    c2=c2.next;
                }
                d.next=new ListNode(s%10);
                d=d.next;
            }
            if(s/10==1)
            {
                d.next=new ListNode(1);
            }
            return sentinel.next;
        }
    }
