package tp;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        var temp = new ListNode();
        temp.next = head;
        var left = temp;
        var right = head;

        while (right != null) {
            if (right.next != null && right.val == right.next.val) {
                while (right.next != null && right.val == right.next.val) {
                    right = right.next;
                }
                left.next = right.next;
            } else {
                left = right;
            }
            right = right.next;
        }

        return temp.next;
    }
}
