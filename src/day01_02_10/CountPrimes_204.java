package day01_02_10;

import java.util.Arrays;

public class CountPrimes_204 {
    public static void main(String[] args) {
        /**
         * 统计所有小于非负整数 n 的质数的数量。 质数也是素数，因数只有1和本身
         */
        System.out.println(countPrimes2(10));
    }

    /**
     * 说明 1不是质数，n = 2 时，没有小于2的质数
     * n = 3时，小于3的质数就一个 2
     * n>3时, 2,3都是质数
     *
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = n > 3 ? 2 : 1;
        for (int i = 5; i < n; i++) {
            if (isPrime(i) == true) {
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int k = (int) Math.sqrt(n) + 1;
        for (int i = 5; i < k; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


    public static int countPrimes2(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++)
            if (isPrim[i])
                // i 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

        return count;

    }

}
