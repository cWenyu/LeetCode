package day01_02_10;

import java.util.List;

public class RemoveElements_203 {
    public static void main(String[] args) {
        /**
         * 删除链表中等于给定值 val 的所有节点。
         */
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;

    }

    /**
     * 错误例子，若要删除的恰巧是头结点，则结果错误
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElementsWrongExample(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = head;
        ListNode prev = sentinel, curr = sentinel.next;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel;

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
