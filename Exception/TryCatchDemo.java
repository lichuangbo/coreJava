/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月20日
 */
package cn.edu.tit.corejava.exception;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author 李创博
 * @version: 1.0
 */
public class TryCatchDemo {
	public static void main(String[] args) {
		/**
		 * 使用场景：
		 * 1. 需要执行到异常后的代码(比如资源的释放等工作)
		 * 2. 父类方法没有抛出异常，子类方法也不能抛出异常，可以内部使用try-catch语句处理
		 * (例如在run方法下进行IO操作)
		 * 	  补充： 父类方法抛出异常，子类方法可以选择抛出相同异常，其子类异常，或者不抛出异常
		 */
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\unintall.log");
			BufferedInputStream bis = new BufferedInputStream(fis);
			System.out.println(bis.read());
		}  catch (FileNotFoundException e) {
			/**
			 * 捕获到的异常通常有三种打印方式
			 * 1.e.toString();	打印出简短的出错信息,重载了Object.toString方法
			 * 2.e.getMessage();	打印出详细信息字符串
			 * 3.e.printStrackTrace();	JVM打印异常对象，信息最全面，红色提示
			 */
//			System.out.println(e.toString()); 
			System.out.println(e.getMessage());
//			e.printStackTrace();
		} catch (IOException e) {
			/**
			 * 注意：
			 * 	当出现一次try，多次catch时，处理的异常存在继承关系，必须先捕获子类异常，再捕获父类异常
			 * 	若先捕获父类异常，那子类异常已经不用捕获，再写就会报错
			 */
			System.out.println(e.toString());
		} finally {
			/**
			 * finally通常要做的工作是释放资源，因为无论程序是否出现异常，都会执行到finally语句
			 * finally语句要结合着try-catch语句使用
			 * finally语句中要避免写return语句，一直执行的是finally语句
			 */
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
