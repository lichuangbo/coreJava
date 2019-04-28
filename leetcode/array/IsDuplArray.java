/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月27日
 */
package cn.edu.tit.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 判断数组是否含有重复元素
 * @author 李创博
 * @version: 1.0
 */
public class IsDuplArray {
	public boolean containsDuplicate(int[] nums) {
		/**
		 * 普通的双重循环
		 * 测试用时423ms
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
		/**
		 * 先将数组进行排序，之后判断相邻数组是否相同即可
		 * 测试用时：10ms
		 */
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containDuplicate2(int []nums) {
		/**
		 * 利用HashSet的不存储重复元素特性，判断set的大小和nums的长度是否一致
		 * 测试用时：22ms
		 */
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		if (set.size() != nums.length) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int []nums = {1, 3, 3, 1};// 1234 false  1231true  1334true
		IsDuplArray ida = new IsDuplArray();
		System.out.println(ida.containDuplicate2(nums));
	}
}
