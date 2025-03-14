import org.junit.jupiter.api.Test;
import sort.GsonUtils;

import java.util.Arrays;
import java.util.List;

public class AddTwoNumbersInLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int canary = 0;
        while (l1 != null || l2 != null || canary != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = canary + x + y;
            canary = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }

    public ListNode initLinkedByList(final List<Integer> values) {
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < values.size(); i++) {
            Integer val = values.get(i);
            ListNode curr = new ListNode(val);
            if (head == null) {
                head = curr;
                tail = curr;
            } else {
                tail.next = curr;
                tail = curr;
            }
        }
        return head;
    }

    @Test
    void test() {
        ListNode l1 = initLinkedByList(Arrays.asList(2, 4, 3));
        System.out.println(GsonUtils.toString(l1));
        ListNode l2 = initLinkedByList(Arrays.asList(5, 6, 4));
        System.out.println(GsonUtils.toString(l2));
        System.out.println(GsonUtils.toString(addTwoNumbers(l1, l2)));
    }
}
