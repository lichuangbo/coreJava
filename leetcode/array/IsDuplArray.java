/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月27日
 */
package cn.edu.tit.leetcode.array;


/**
 * 判断数组是否含有重复元素
 * @author 李创博
 * @version: 1.0
 */
public class IsDuplArray {
	public boolean containsDuplicate(int[] nums) {
		/**
		 * 测试用时423ms
		 * flag	超时
		 */
        for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (temp == nums[j]) {
					return true;
				}
			}
		}
		return false;
    }
	
	public boolean containDuplicate1(int []nums) {
		int flag = 0;
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i];
			if (nums[flag] == temp) {
//				flag++;
				return true;
			}
//			flag++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int []nums = {1, 3, 3, 4};// 1234 false  1231true  1334true
		IsDuplArray ida = new IsDuplArray();
		System.out.println(ida.containDuplicate1(nums));
	}
}
