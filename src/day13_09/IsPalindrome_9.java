package day13_09;

public class IsPalindrome_9 {
    public static void main(String[] args) {
        //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        System.out.println(isPalindrome(2147483647));
    }

    /**
     * 用字符串处理要注意溢出的问题
     * 字符串处理时候会开辟新的空间，效率会更低，考虑数学逻辑解决
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        //判断是否为负数，负数直接返回false
        if (x < 0) {
            return false;
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(x);
        int reversedX = (int) Long.parseLong(stringBuffer.reverse().toString());

        if (reversedX > Integer.MAX_VALUE || x != reversedX) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPalindrome2(int x) {
        //判断是否为负数，负数直接返回false
        //尾数是0也可直接返回false，因为任何末尾为0的数字翻转后都不会是回文数字
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        //处理数字
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
