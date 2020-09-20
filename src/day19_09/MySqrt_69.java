package day19_09;

public class MySqrt_69 {
    public static void main(String[] args) {
        /**
         * 实现int sqrt(int x)函数。
         *
         * 计算并返回x的平方根，其中x 是非负整数。
         *
         * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/sqrtx
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        System.out.println(mySqrt2(8));
    }

    public static int mySqrt(int x) {
        if (x < 0) {
            throw new RuntimeException("无效数字: " + x);
        }

        return (int) Math.sqrt(x);
    }

    /**
     * 一个数的平方根不会超过其一半，(int)sqrt8 = 2 8/2 = 4;
     * 这就是为什么右边界right=x/2
     *
     * @param x
     * @return
     */
    public static int mySqrt2(int x) {
        if (x == 0) return 0;

        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;

        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (right + left) / 2 + 1;
            System.out.println("mid: " + mid);
            //为什么 mid > (x/mid)?
            /**
             * long square = mid * mid;
             * 如果suqare > x，例如8，8/2 = 4， 4^2 = 16， 16>8, right需要左移一位，即为3
             * 3^2 = 9,9>8,right需要左移，
             * 2^2 = 4 < 8, left = 1,right=2
             *1<2, mid=(2+1)/2+1 = 2,
             */
            if (mid > (x / mid)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        /*long left = 1;
        long right = x / 2;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }*/

        return (int) left;
    }

    public static int mySqrt3(int x) {
        if (x == 0) return 0;

        int left = 1, right = x / 2;

        while (left < right) {
            //为什么+1？
            //若不+1, mid永远取得是左边界，会陷入死循环
            int mid = (right + left) / 2 + 1;
            if (mid > (x / mid)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }


}
