package day19_09;

public class ClimbStairs_70 {
    static int count = 0;

    public static void main(String[] args) {
        /**
         * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
         *
         * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
         *
         * 注意：给定 n 是一个正整数。
         */

        System.out.println(climbStairs(4));
    }

    /**
     * 1,1,2,3,5,8.....
     * 斐波那契函数, F[n]=F[n-1]+F[n-2] n ≥ 3
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        //只有一个台阶时，dp[0] = 1,只能走一步达到目的
        //只有2个台阶时，dp[0] = 1,dp[1] = 1, 1个台阶+1个台阶 或者直接走两个台阶
        //3个台阶时，dp[0] = 1,dp[1] = 1，dp[2] = 2, 3个台阶时有2种方法 （1+2），（2+1），（1+1+1）
        //4个台阶时，dp[0] = 1,dp[1] = 1，dp[2] = 2, dp[3] = 3,4个台阶时有5种方法 即为2+3=5
        dp[0] = dp[1] = 1;

        // i= 2 满足了斐波那契函数 n>=3,从第三位开始
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
