/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月27日
 */
package cn.edu.tit.leetcode.array;

/**
 * 买卖股票的最佳时机II,得到最大利润
 * @author 李创博
 * @version: 1.0
 */
public class MaxProfit {
	public int maxProfit(int []prices) {
		/**
		 * 题目：
		 * 	给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
		* 	设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（可多次买卖一支股票,但再次购入时必须抛售掉先前的）。
		* 思想：
		* 	贪心算法，总是做出在当前看来是最好的选择，不从整体最优上加以考虑，也就是说，只关心当前最优解
		* 实现：
		* 	有利润要求数组内局部递增，今天价高于昨天价就抛售，明天价高于今天价就买入
		 */
		int maxProfit = 0;
		for(int i = 0; i < prices.length - 1; i++) {
			int tempProfit = prices[i + 1] - prices[i];// -6 4 -2 3 -2
			if(tempProfit > 0) {
				maxProfit += tempProfit;
			}
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		int []prices = {7, 1, 5, 3, 6, 4};
		
		MaxProfit mp = new MaxProfit();
		int maxProfit = mp.maxProfit(prices);
		System.out.println(maxProfit);
	}
}
