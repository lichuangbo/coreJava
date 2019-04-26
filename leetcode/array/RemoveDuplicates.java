/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月26日
 */
package cn.edu.tit.leetcode.array;


/**
 * 在不增加空间的情况下从排序数组中删除重复项
 * @author 李创博
 * @version: 1.0
 */
public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		/**
		 * 思想：
		 * 	flag标记第一个元素，i标记第二个元素并开始遍历，
		 * 如果nums[i]!=nums[flag],就将i元素放在flag之后
		 * flag用来记录调整后数组的索引，慢指针
		 * i用来遍历原数组，寻找和nums[flag]数值不一样的元素，快指针
		 */
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int flag = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[flag] != nums[i]) {
				flag++;
				nums[flag] = nums[i];
			}
		}
		return flag + 1;
    }
	
	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

		int len = rd.removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.println(nums[i]);
		}
	}
}
