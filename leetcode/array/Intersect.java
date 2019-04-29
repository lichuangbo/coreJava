/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月28日
 */
package cn.edu.tit.leetcode.array;

import java.util.ArrayList;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @author 李创博
 * @version: 1.0
 */
public class Intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
		/**
		 * 利用ArrayList的有序可重复特性
		 * 测试用时：18ms
		 */
		ArrayList<Integer> list1 = new ArrayList<>();
		for (int num : nums1) {
			list1.add(num);
		}
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int num : nums2) {
			if (list1.contains(num)) {
				list2.add(num);
				// 从 list1 除去已匹配的数值
				list1.remove(Integer.valueOf(num));
			}
		}
		int []temp = new int[list2.size()];
		int i = 0;
		for (int num : list2) {
			temp[i] = num;
			i++;
		}
		return temp;
    }
	
	public static void main(String[] args) {
		Intersect in = new Intersect();
		int []nums1 = {1, 2, 2, 1};
		int []nums2 = {2, 2};
		int []result = in.intersect(nums1, nums2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
