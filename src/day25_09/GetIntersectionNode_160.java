package day25_09;

import java.util.HashSet;

public class GetIntersectionNode_160 {
    public static void main(String[] args) {
        /**
         * 编写一个程序，找到两个单链表相交的起始节点。
         *
         * 如果两个链表没有交点，返回 null.
         * 在返回结果后，两个链表仍须保持原有的结构。
         * 可假定整个链表结构中没有循环。
         * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        //解法1: 双重循环
        //解法2: 哈希表
        //解法3: 双指针

        ListNode headA = new ListNode(4);
        ListNode a1 = new ListNode(1);
        ListNode headB = new ListNode(5);
        ListNode b1 = new ListNode(0);
        ListNode b2 = new ListNode(1);

        ListNode same1 = new ListNode(8);
        ListNode same2 = new ListNode(4);
        ListNode same3 = new ListNode(5);

        same1.setNext(same2);
        same2.setNext(same3);

        headA.setNext(a1);
        a1.setNext(same1);

        headB.setNext(b1);
        b1.setNext(b2);
        b2.setNext(same1);

        ListNode result = getIntersectionNode3(headA, headB);
        System.out.println(result);
    }

    /**
     * 解法一：双重循环
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null) {
            while (curB != null) {
                if (curA == curB) {
                    return curA;
                }
                curB = curB.next;
            }
            curA = curA.next;
            curB = headB;
        }
        return null;
    }

    /**
     * 解法二：Hash值
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeSetA = new HashSet<>();
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            nodeSetA.add(curA);
            curA = curA.next;
        }

        while (curB != null) {
            if (nodeSetA.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }

    /**
     * 解法三： 双指针
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {
            if (p == null) {
                p = headB;
            } else {
                p = p.next;
            }

            if (q == null) {
                q = headA;
            } else {
                q = q.next;
            }

            // 同 if(p==null) p=headB else p = p.next;
//            p = (p == null) ? headB : p.next;
//            q = (q == null) ? headA : q.next;
        }
        return p;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
