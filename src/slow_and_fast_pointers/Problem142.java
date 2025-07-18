package slow_and_fast_pointers;

import data_structures.ListNode;

public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;

        while (fast != null && fast.next != null) {
            if (slow == fast.next) {
                slow = slow.next;
                while (start != slow) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Problem142 p = new Problem142();
        // Create nodes
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Link nodes: 3 -> 2 -> 0 -> -4
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create a cycle: -4 -> 2 (cycle starts at second node)
        fourth.next = second;

        System.out.println(p.detectCycle(head).val);
    }
}
