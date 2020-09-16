package sumTwo;

public class linkedSum {
    public static void main(String[] args) {
        /**
         * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
         *
         * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
         *
         * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
         *
         * 示例：
         *
         * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
         * 输出：7 -> 0 -> 8
         * 原因：342 + 465 = 807
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/add-two-numbers
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        sum(12);
//        System.out.println(12/10);
    }

    public static void sum(int num) {
        if (num >= 10) {
            int a = num / 10;
            double dev = (double) num / 10;
            System.out.println(a);

            double dec = dev - num / 10;
//            int res = dec*10;
            System.out.println(dec * 10);
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个指针
        ListNode head = new ListNode(0);
        ListNode cur = head;


        while (l1 != null || l2 != null) {
            int sum = l1.val + l2.val;
            if (sum >= 10) {
                int a = sum / 10;
                double dev = sum / 10;
                sum = (int)((dev - a) * 10);
                cur.next.next = new ListNode(sum);
            }
            cur.next = new ListNode(sum);
            System.out.printf("%d,%d,sum: %d\n", l1.val, l2.val, l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        return cur.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
