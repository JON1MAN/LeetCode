package slow_and_fast_pointers;

import data_structures.ListNode;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        slow.next = head;

        while (fast != null && fast.next != null) {
            if (slow == fast.next) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem141 p = new Problem141();
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

        System.out.println(p.hasCycle(head));
    }
}
