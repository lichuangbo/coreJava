/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月1日
 */
package cn.edu.tit.leetcode;

import java.util.HashMap;

/**
 * 两数之和
 * @author 李创博
 * @version: 1.0
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        /**
         * 毫无技巧性的双重循环
         * 测试用时48ms
         */
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		return null;
    } 
	
	public int[] twoSum2(int[] nums, int target) {
		/**
		 * 思想：
		 * 	先将数组元素及其索引放入map集合中，反向寻找目标元素是否在集合中
		 * 测试用时：9ms
		 */
		HashMap<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int temp = target - nums[i];
	        if (map.containsKey(temp) && map.get(temp) != i) {
	            return new int[] { i, map.get(temp) };
	        }
	    }
		return null;
	}
	
	public int[] twoSum3(int[] nums, int target) {
		/**
		 * 方法二改进为一次循环(很巧妙，不太好想)
		 * 并没有将所有元素添加进来，边添加边判断同步进行
		 * 测试用时：7ms
		 */
		HashMap<Integer,Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp) && map.get(temp) != i) {
				return new int[] {map.get(temp), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
	
	public static void main(String[] args) {
		int []nums = {2, 3, 7, 11, 15};
		int target = 5;
		TwoSum ts = new TwoSum();
		int []result = ts.twoSum3(nums, target);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
