package day22_09;

public class MaxProfit_121 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意：你不能在买入股票前卖出股票
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] prices = {1, 2};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    public static int maxProfit(int[] prices) {
        //prices = []
        if (prices.length == 0) return 0;
        int lowest = prices[0], sell = 0, profix = 0;
        for (int i = 1; i < prices.length; i++) {
            System.out.println(i);
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            if (prices[i] > lowest) {
                sell = prices[i];
                profix = Math.max(profix, (sell - lowest));
            }
        }
        return profix;
    }
}
