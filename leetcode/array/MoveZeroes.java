/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月1日
 */
package cn.edu.tit.leetcode.array;

import java.util.ArrayList;

/**
 * 移动零(2048小游戏中有这操作)
 * @author 李创博
 * @version: 1.0
 */
public class MoveZeroes {
	public void moveZeroes(int []nums) {
		/**
		 * 0,	1,	0,	3,	12
		 * 1,	0,	3,	12,	0	第一趟
		 * 1,	3,	12,	0,	0
		 * 
		 * 相邻元素交换：
		 * 	左元素为0，且右元素不为0就交换，设置flag进行次数优化
		 * 测试用时：71ms
		 */
		if (nums.length == 0 || nums == null) {
			return;
		}
		boolean flag = true;
		while(flag) {
			flag = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i] == 0 && nums[i + 1] != 0) {
					int temp = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = temp;
					flag = true;
				}
			}
		}
	}
	
	public void moveZeroes2(int []nums) {
		/**
		 * 1,	3,	12,	0,	0
		 * d---->--->	<---<
		 * 0,	1,	0,	3,	12
		 * i---->--->--->---->
		 * 双指针法:
		 * 	index指针存储; i指针遍历，不等于零交给index处理，便利完毕将后面的置零。
		 * 测试用时1ms
		 */
		if (nums.length == 0 || nums == null) {
			return;
		}
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[index++] = nums[i];
			}
		}
		for (int i = nums.length - 1; i >= index; i--) {
			nums[i] = 0;
		}
	}
	
	public void moveZeroes3(int []nums) {
		/**
		 * 利用ArrayList的有序性存储(使用了外部空间，不符合题意)
		 * 	将不等于零的元素暂存在集合中，之后全部移送到数组中，后面置零
		 * 测试用时4ms
		 */
		if (nums.length == 0 || nums == null) {
			return;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) 
			if (nums[i] != 0) 
				list.add(nums[i]);
		int index = 0;
		for (Integer k : list) {
			nums[index++] = k;
		}
		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		int []nums = {0, 1, 0, 3, 12};
		MoveZeroes mz = new MoveZeroes();
		mz.moveZeroes3(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
