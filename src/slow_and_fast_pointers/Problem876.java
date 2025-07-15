package slow_and_fast_pointers;

import data_structures.ListNode;

public class Problem876 {
    public ListNode middleNode(ListNode head) {
        var medium = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            medium = medium.next;
        }

        return medium;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6,
                                                        new ListNode(7)
                                                )
                                        )
                                )
                        )
                )
        );

        Problem876 p = new Problem876();
        var res = p.middleNode(head);

        var temp = res;

        while (temp != null) {
            System.out.println(res.val);
            temp = res.next;
            res = res.next;
        }
    }
}
