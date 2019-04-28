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
public class InterfaceDemo implements MyInterface{
	/**
	 * 接口实现类注意事项：
	 * 	1.一个类可以实现多个接口
	 * 	2.除实现类为抽象类外，其他类必须实现接口中定义的所有抽象方法
	 * 	3.实现的多个接口中，存在重复的默认方法，实现类一定要对冲突的默认方法覆盖重写
	 * 	4.直接父类的方法和接口中的默认方法产生冲突，优先调用父类中的方法
	 */

	@Override
	public void methodA() {
		System.out.println("实现类重写了methodA方法");
	}
	
	public static void main(String[] args) {
		//接口可以实现多态
		MyInterface mf = new InterfaceDemo();
		
		InterfaceDemo id = new InterfaceDemo();
		System.out.println("实现类调用接口变量：" + id.X_INT);
		id.methodA();
		id.methodB();
		
		//通过接口名称直接调用静态方法
		MyInterface.methodC();
		
		id.aaa();
	}
	
	public void aaa() {
		//实现类方法中可以直接调用接口的默认方法
		methodB();
	}
}
