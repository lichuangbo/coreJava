/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月28日
 */
package cn.edu.tit.corejava.javagrammar;

/**
 * @author 李创博
 * @version: 1.0
 */
public abstract interface MyInterface{
	/**
	 * 接口特性：
	 * 	1.声明接口时，隐式指定为public abstract
	 * 	2.接口中的抽象方法被隐式指定为public abstract
	 * 	3.接口中的变量被隐式指定为public static final
	 * 	4.接口支持多继承,接口不能'实现'接口，能继承接口
	 * 	5.接口中不能写实现的方法、静态代码块和构造方法
	 * 接口中可以包含的内容：
	 * 	JDK7：成员'变'量，抽象方法
	 * 	JDK8：增加默认方法，静态方法
	 * 	JDK9：增加私有方法
	 */
	
	//声明一个变量,接口中的成员变量必须赋值
	public static final int X_INT = 1;
	//声明一个抽象方法
	public abstract void methodA();
	
	public default void methodB() {
		/**
		 * 声明一个默认方法
		 * 用途：
		 * 	当系统中的类已经实现了接口并且上线，此时想在原接口中添加方法；
		 * 	如果按照之前的，声明抽象方法，那所有实现了此接口的类都要添加此方法，否则报错。
		 *  这时，可以声明它为default类型，实现此接口的类可以选择是否重写此方法，
		 *  此方法会被默认继承下去。
		 */
		System.out.println("这是接口的默认方法！");
	}
	
	public static void methodC() {
		/**
		 * 声明一个静态方法
		 * 使用：
		 * 	通过接口名称直接调用静态方法，不能使用实现类对象调用
		 */
		System.out.println("这是接口的静态方法！");
	}
	
	/**
	 * 声明一个私有方法：只能接口内部自己使用
	 * 用途：
	 * 		方法中存在冗余代码，想要将代码提取出来，又不想让实现类使用(私有化)。
	 * 普通私有方法：
	 * 		解决多个默认方法之间的冗余代码
	 * 静态私有方法：
	 * 		解决多个静态方法之间的冗余代码
	 */
	
	private int methodD() {
		return 1;
	}
	private static void methodE() {
		
	}
}
