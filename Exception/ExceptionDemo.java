/**
 * CopyRight © 2019太原工业学院计算机工程系.All rights reserved.
 * 
 * @date: 2019年4月19日
 */
package cn.edu.tit.corejava.thread;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author 李创博
 * @version: 1.0
 */
public class ExceptionDemo {
	/**
	 * java.lang.Throwable类是所有异常和错误的超类
	 * 		Exception
	 * 		RuntimeException
	 * 		Error
	 * 处理异常常见方法：
	 * 		throws ParseException:抛出异常，由Java虚拟机处理，会中断程序
	 *		try-catch语句处理：处理异常后，程序可以继续执行
	 */
	public static void main(String[] args) {
		/**
		 * Exception:(CheckedException)编译期间出现异常，程序可以处理且应该被捕获的异常
		 * 属于应用程序级别的异常
		 * 常见的有：
		 * 	IOException,SQLException
		 */
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = null;
//		try {
//			date = sdf.parse("2019-04-19");
//		}catch(ParseException e){
//			System.out.println(e);
//		}
//		System.out.println(date);
		
		/**
		 * RuntimeException:(UncheckedException),在Java虚拟机的正常操作期间可以抛出的那些异常的超类
		 * 非检查性系统异常，一般是程序员的疏忽，不需要try-catch处理，交予JVM处理 
		 * 常见的有：
		 * 	空引用异常，类型转化异常，数组越界异常
		 */
//		int []arr = {1, 2, 3};
//		System.out.println(arr[0] + arr[3]);
//		String str = null;
//		System.out.println(str.charAt(0));
		
		/**
		 * Error，(UncheckedException)程序无法恢复也不应该试图捕获的异常
		 * 内存溢出
		 */
		int[] arr = new int[1024*1024*1024];
	}
	
}
