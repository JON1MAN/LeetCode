package slow_and_fast_pointers;

import data_structures.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> array = new ArrayList<>();
        createArrayFromNode(array, list1);
        createArrayFromNode(array, list2);

        array.sort(Comparator.naturalOrder());

        if (array.isEmpty()) {
            return null;
        }

        List<ListNode> nodes = new ArrayList<>();
        array.forEach(integer -> nodes.add(new ListNode(integer)));

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        return nodes.getFirst();
    }

    private List<Integer> createArrayFromNode(List<Integer> array, ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            array.add(head.val);
            head = head.next;
            temp = head;
        }

        return array;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)
                                )
                        )
                )
        );

        ListNode node2 = new ListNode(6,
                new ListNode(7,
                        new ListNode(8,
                                new ListNode(9,
                                        new ListNode(10)
                                )
                        )
                )
        );

        Problem21 p = new Problem21();

        System.out.println(p.mergeTwoLists(node1, node2).val);
    }
}
