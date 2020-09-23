package day23_09;

import java.util.HashSet;
import java.util.Set;

public class HasCycle_141 {
    public static void main(String[] args) {
        /**
         给定一个链表，判断链表中是否有环。

         如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 - 1，则在该链表中没有环。
         注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

         如果链表中存在环，则返回 true 。否则，返回 false 。

         来源：力扣（LeetCode）
         链接：https:
         //leetcode-cn.com/problems/linked-list-cycle
         著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         **/
    }

    /**
     * 遇到一个不是环形的Node，就加入到nodesSet中，head后移，破坏了链表的结构
     * 如果nodesSet中含有head时，证明有环形存在，返回true，
     * 当所有Node都加入到nodesSet中，都没有相同的节点时候，返回false
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSet = new HashSet<>();
        while (head != null) {
            if (nodesSet.contains(head)) {
                return true;
            } else {
                nodesSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针，双指针，
     *
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        //如果只有一个节点，或者head是空节点, 返回false
        if (head == null || head.next == null) {
            return false;
        }

        //链表有一个以上的节点： 慢指针指向头结点，快指针指向head.next
        ListNode slow = head;
        ListNode fast = head.next;

        //slow == fast 的时候退出循环， 因为fast如果遇到环形时会一直在其中循环，slow会遇上fast
        while (slow != fast) {
            //若fast为空或者fast.next为空，证明无环形链表，fast不会再更新了
            if (fast == null || fast.next == null) {
                return false;
            }

            //否则 fast永远比slow快2步，拉开距离
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
