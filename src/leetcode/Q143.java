package leetcode;

/**
 * @author qin
 * @date 2020-10-20
 */
public class Q143 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

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

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }

    private ListNode reversedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNext;
        }
        return pre;
    }

    private void mergeTwoList(ListNode list1, ListNode list2) {
        while (list2 != null) {
            ListNode tempNextList1 = list1.next;
            ListNode tempNextList2 = list2.next;
            list1.next = list2;
            list2.next = tempNextList1;
            list1 = tempNextList1;
            list2 = tempNextList2;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode midNode = getMidNode(head);
        ListNode revdMidNode = reversedList(midNode);
        ListNode list1 = head;
        ListNode list2 = revdMidNode;
        mergeTwoList(list1, list2);
        return;

    }

}
