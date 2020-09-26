package day26_09;

import java.math.BigInteger;

public class TrailingZeroes_172 {
    public static void main(String[] args) {
        /**
         * 给定一个整数 n，返回 n! 结果尾数中零的数量。
         */

        System.out.println(trailingZeroes(30));
    }

    /**
     * 计算阶乘，每次 %10
     *
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;

        //考虑溢出
        BigInteger nFactorial = BigInteger.ONE;

        //得到阶乘值
        while (n > 1) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(n--));
        }

        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            count++;
        }
        return count;
    }

    /**
     * 计算有多少个5的倍数
     *
     * @param n
     * @return
     */

    public static int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
