/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月30日
 */
package cn.edu.tit.leetcode.array;

/**
 * 加一
 * @author 李创博
 * @version: 1.0
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		/**
		 * 1, 1, 9	->	1, 2, 0
		 * 1, 9, 9	->	2, 0, 0
		 * 9, 9, 9	->1,0, 0, 0	此时要增加空间
		 * 末位：逢9改0	非9进1(中止程序) 
		 * 
		 * 测试用时：1ms
		 */
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				return digits;
			}
			digits[i] = 0;
		}
		int []temp = new int[digits.length + 1];
		temp[0] = 1;
		return temp;
    }
	public static void main(String[] args) {
		PlusOne po = new PlusOne(); 
		int []digits = {1, 2, 3, 9, 9};//1, 3, 6, 0, 0
		
		int []temp = po.plusOne(digits);
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
	}
}
