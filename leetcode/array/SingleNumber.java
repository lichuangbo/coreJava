/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月28日
 */
package cn.edu.tit.leetcode.array;

import java.util.Arrays;


/**
 * 除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * @author 李创博
 * @version: 1.0
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
		/**
		 * 先进行排序，之后分别判断左元素、右元素和自己是否相等，不相等返回自己
		 * 测试用时：11ms
		 */
		Arrays.sort(nums);
		if (nums.length == 1 || nums[0] != nums[1]) {
			return nums[0];
		}
		if (nums[nums.length - 1] != nums[nums.length - 2]) {
			return nums[nums.length - 1];
		}
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
        return -1;
    }
	
	public int singleNumber1(int []nums) {
		/**
		 * 先进行排序，和相邻的下一个元素比较，相等步长+2，不相等返回当前元素
		 * 测试用时：8ms
		 */
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i = i + 2) {
	        if (i + 1 >= nums.length) {
	            return nums[i];
	        }
	        if (nums[i] != nums[i + 1]) {
	            return nums[i];
	        }
	    }
		return -1;
	}
		
	public int singleNumber2(int []nums) {
		/**
		 * 相对应位数相同结果为0， 否则为1-->两个相同数做^运算，结果为0
		 * 将所有元素进行^运算，结果就为那单个数
		 * 1	2	 2
		 * 01   10   10
		 *c00   01   11
		 * 01   11   01
		 * 补充：
		 * 	& 两者同时为真才为真
		 * 	| 两者一者为真就为真
		 *  ^ 相同为假，不同为真
		 */
		int c = 0; 
        for(int n:nums){
            c = c ^ n;
        }
        return c;
	}
	
	public static void main(String[] args) {
		int []nums = {4, 1, 2, 1, 2};
		
		SingleNumber sn = new SingleNumber();
		System.out.println(sn.singleNumber2(nums));
	}
}
