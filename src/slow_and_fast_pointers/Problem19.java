package slow_and_fast_pointers;
import data_structures.ListNode;

public class Problem19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        var start = new ListNode(0);
        var slow = start;
        var fast = start;

        slow.next = head;

        for (int i = 0; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)
                                )
                        )
                )
        );

        Problem19 p = new Problem19();
        System.out.println(p.removeNthFromEnd(head, 3));

    }
    
}
