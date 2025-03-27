class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
        this.next = null;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // Find the penultimate node (second last node)
        ListNode penultimate = head;
        while (penultimate.next.next != null) {
            penultimate = penultimate.next;
        }

        // Link the penultimate node's next (last node) to the second element
        penultimate.next.next = head.next;
        head.next = penultimate.next;

        // Set the penultimate node's next to null (disconnect last node)
        penultimate.next = null;

        // Recursively reorder the remaining list
        reorderList(head.next.next);
    }
}
