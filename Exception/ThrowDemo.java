/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月19日
 */
package cn.edu.tit.corejava.exception;

/**
 * @author 李创博
 * @version: 1.0
 */
public class ThrowDemo {
	/**
	 * throw关键字
	 *     可以在指定的方法中抛出指定的异常
	 * 格式：
	 *     throw new ***Exception("异常产生原因")
	 * 注意：
	 *     throw关键字必须写在方法的内部
	 *     throw关键字后创建的对象必须是Exception或者Exception的子类对象
	 */
	public static int getElement(int[] arr, int index) {
		/**
		 * 对方法传递过来的参数进行合法性验证，能够减少不必要的异常
		 */
		if(arr == null) {
			throw new NullPointerException("传递的数组为null");
		}
		if(index < 0 || index > arr.length - 1) {
			throw new ArrayIndexOutOfBoundsException("索引参数超出数组使用范围");
		}
		int ele = arr[index];
		return ele;
	}
	
	public static void main(String[] args) {
		int []arr = {1, 2, 3};
		int x = getElement(arr, -1);
	}
}
