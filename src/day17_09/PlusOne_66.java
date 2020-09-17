package day17_09;

import java.util.Arrays;

public class PlusOne_66 {
    public static void main(String[] args) {
        /**
         * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
         *
         * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
         *
         * 你可以假设除了整数 0 之外，这个整数不会以零开头。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/plus-one
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        int[] arr = {9,9};
        System.out.println(Arrays.toString(plusOne(arr)));

    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            //判断有无进位
            //无进位 直接返回digits
            //否则继续循环digits
            if (digits[i] != 0) {
                return digits;
            }
        }
        //循环结束时若无返回值，则证明digits[0]需要进位
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;

    }
}
