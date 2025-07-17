package slow_and_fast_pointers;

import data_structures.ListNode;

public class Problem234 {
    public int isPalindrome(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode mid = start;
        ListNode last = start;
        mid.next = head;

        while (last != null && last.next != null) {
            mid = mid.next;
            last = last.next.next;
        }

        ListNode dum = mid;
        ListNode prev = mid;
        ListNode temp;

        while (dum != null) {
            temp = mid.next;
            mid.next = prev;
            prev = mid;
            mid = temp;
            dum = temp;
        }

        int count = 0;

        while (count == 0) {
            if (prev == prev.next) count = 1;
            if (prev.val != head.val) {
                return 0;
            }
            prev = prev.next;
            head = head.next;
        }

        return 1;
    }

    public static void main(String[] args) {
        Problem234 p = new Problem234();
        ListNode head = new ListNode(0,
                new ListNode(0,
                        new ListNode(0,
                                new ListNode(1,
                                        new ListNode(0)
                                )
                        )
                )
        );
        System.out.println(p.isPalindrome(head));
    }
}
