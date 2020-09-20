package day20_09;

public class DeleteDuplicates_83 {
    public static void main(String[] args) {
        /**
         * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
         */
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        deleteDuplicates(l1);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        //若当前节点为空 或者 当前节点的下一个节点为空，直接退出即可
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
            System.out.println(cur);
        }
        //为什么可以直接返回head？
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
