package tp;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        var left = head;
        var right = head.next;
        var previous = left;

        while (right != null) {
            if (left.val != right.val) {
                left.next = right;
                previous = left;
                left = right;
                right = left.next;
            } else {
                while (left.val == right.val) {
                    right = right.next;
                }
                left = previous;
            }
        }
        return head;
    }
}
