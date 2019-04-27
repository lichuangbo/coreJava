/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月27日
 */
package cn.edu.tit.leetcode.array;


/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @author 李创博
 * @version: 1.0
 */
public class RotateArray {
	/**
	 * 右旋转数组
	 * @param nums int型数组
	 * @param k 移动位数
	 * @return: void
	 */
	public void rotate(int[] nums, int k) {
		/**
		 * {7, 1, 2, 3, 4, 5, 6}移动一位
		 * {6, 7, 1, 2, 3, 4, 5}移动两位
		 * 思想：
		 * 	局部替换，根据位数确定循环多少轮(左旋是常规思路，那右旋就是倒序的替换)
		 * 测试用时152ms,超过19%的Java的玩家
		 */
		k = k % nums.length;//取余减少循环，提高效率
        for (int i = 0; i < k; i++) {
			for (int j = nums.length - 1; j > 0; j--) {
				int temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
			}
		}
    }
	
	public void rotate1(int []nums, int k) {
		/**以k=3为例
		 *{4, 3, 2, 1, 5, 6, 7}先反转前(7-3=4)个元素
		 *{4, 3, 2, 1, 7, 6, 5} 再反转后后3个元素
		 *{5, 6, 7, 1, 2, 3, 4}最后反转全部元素
		 *神仙级思想
		 *测试用时1ms,超过95的Java玩家
		 */
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1 - k);
	    reverse(nums, nums.length - k, nums.length - 1);
	    reverse(nums, 0, nums.length - 1);
	}
	private void reverse(int []nums, int start, int end) {
		// 翻转数组：折半思想
		while (start < end) {
	        int tmp = nums[start];
	        nums[start++] = nums[end];
	        nums[end--] = tmp;
	    }
	}
	public static void main(String[] args) {
		int []nums = {1, 2, 3, 4, 5, 6, 7};
		
		RotateArray ra = new RotateArray();
//		ra.rotate(nums, 4);
		ra.rotate1(nums, 4);
		
//		ra.reverse(nums, 0, nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
