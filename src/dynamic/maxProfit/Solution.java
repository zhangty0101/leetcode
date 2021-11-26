package dynamic.maxProfit;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

public class Solution {

    /**
     * buy 表示 当前或之前买入的最小成本, buy = min(buy, price[i])
     * sell 表示当前或之前卖出的最大收益, sell = max(sell, price[i] - buy)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;
        for (int i=1; i<prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, prices[i] + buy);
        }
        return sell;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}
