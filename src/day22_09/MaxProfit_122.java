package day22_09;

public class MaxProfit_122 {
    public static void main(String[] args) {
        /**
         * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
         *
         * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
         *
         * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */

        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println(profit);

    }

    /**
     * 画出折线图可知，后一天卖出-前一天买入 >0的时候被记入总利润中 （不能同一天买进卖出）
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
