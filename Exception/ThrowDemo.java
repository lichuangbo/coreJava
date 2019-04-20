/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月19日
 */
package cn.edu.tit.corejava.exception;

import java.io.FileNotFoundException;
import java.util.Objects;


/**
 * @author 李创博
 * @version: 1.0
 */
public class ThrowDemo {
	/**
	 * throw关键字
	 *     $可以在指定的方法中抛出单个异常对象，由方法体内的语句执行
	 * 格式：
	 *     throw new ***Exception("异常产生原因")
	 * 注意：
	 *     $throw必须写在方法的内部
	 *     throw后创建的对象必须是Exception或者Exception的子类对象
	 *     	throw后边创建的是RuntimeException或者是其子类，不用处理
	 *     $throw后边创建的是Exception编译异常，必须处理此异常，要么throws，要么try-catch捕获
	 * throws关键字：
	 * 		$把方法内部全部异常类型抛出给方法的调用者，层层抛出，最后JVM会中断处理
	 * 格式：
	 * 		在方法声明最后throws ***Exception
	 * 注意：
	 * 		$throws必须写在方法的声明处
	 * 		throws后对象必须是Exception或者Exception的子类对象
	 *      	方法内部抛出多个异常对象，throws后边也要声明多个异常类型
	 *      	异常对象存在继承关系，抛出父类异常即可
	 *      $调用了一个声明抛出异常的方法，此方法就必须接着处理这个异常
	 */
	public static int getElement(int[] arr, int index) {
		/**
		 * 对方法传递过来的参数进行合法性验证，能够减少不必要的异常
		 */
//		if(arr == null) {
//			throw new NullPointerException("传递的数组为null");
//		}
		//引用Objects对象的requireNonNull方法，简化代码
		Objects.requireNonNull(arr, "传递的数组为null");
		
		if(index < 0 || index > arr.length - 1) {
			throw new ArrayIndexOutOfBoundsException("索引参数超出数组使用范围");
		}
		int ele = arr[index];
		return ele;
	}
	
	public static void readFile(String fileName) throws FileNotFoundException {
		if(!fileName.equals("D:\\1.txt")) {
			throw new FileNotFoundException("找不到指定文件");
		}
	}
	
	public static void main(String[] args) {
//		int[] arr = null;
//		int x = getElement(arr, 1);
		int[] arr = {1, 2, 3};
		int x = getElement(arr, -1);
	}
}
