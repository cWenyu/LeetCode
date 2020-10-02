package day01_02_10;

import java.util.HashSet;

public class IsHappy_202 {
    public static void main(String[] args) {
        /**
         * 编写一个算法来判断一个数 n 是不是快乐数。
         *
         * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
         *
         * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/happy-number
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        boolean happy = isHappy(19);
        System.out.println(happy);

    }

    /**
     * 1. hash set 判断是否进入循环，若存在则退出判断，返回false不是快乐数字
     * 若新得到的n 是1，返回true，是快乐数
     * @param n
     * @return newN是否等于1
     */
    public static boolean isHappy(int n) {
        HashSet<Integer> sums = new HashSet<>();

        while (n != 1 && !sums.contains(n)) {
            sums.add(n);
            n = getNewN(n);
        }

        return n == 1;
    }

    /**
     * 快慢指针，初始时，快指针比慢指针快一步，随后慢指针走一步，快指针走两步
     * @param n
     * @return 快指针是否等于1
     */
    public static boolean isHappy2(int n) {
        int p = n, q = getNewN(n);

        while (q != 1 && p != q) {
            p = getNewN(p);
            q = getNewN(getNewN(q)); // !!!快指针要走两步
        }

        return q == 1;
    }

    /**
     * 快慢指针，同haspSet一样，只不过是个隐式链表
     * @param n
     * @return
     */
    public static boolean isHappy3(int n) {
        int p = n, q = getNewN(n);

        while (q != 1 && p != q) {
            p = getNewN(p);
            q = getNewN(getNewN(q)); // !!!快指针要走两步
        }

        return q == 1;
    }


    public static int getNewN(int n) {
        int sum = 0, mod = 0;
        while (n > 0) {
            mod = n % 10;
            sum += mod * mod;
            n = n / 10;
        }
        return sum;
    }
}
