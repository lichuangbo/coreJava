/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月28日
 */
package cn.edu.tit.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 两个数组的交集 II
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
				//将num从list1中移除，避免list2重复
				//remove(Object o),否则会将num解析为索引
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
	
	public int[] intersect1(int[] nums1, int[] nums2) {
		/**
		 * 先进行排序，之后双指针移动比较，k指针存放
		 *测试用时2ms
		 */
		if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                nums1[k] = nums1[i];
                k ++;
                i ++;
                j ++;
            }else if (nums1[i] > nums2[j]) {
                j ++;
            } else {
                i ++;
            }
        }
        return Arrays.copyOf(nums1, k);
	}
	
	public static void main(String[] args) {
		Intersect in = new Intersect();
		int []nums1 = {3, 1, 2};
		int []nums2 = {1};
		int []result = in.intersect1(nums1, nums2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
