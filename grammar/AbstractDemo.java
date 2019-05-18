/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月30日
 * @date: 2019年5月17日
 */
package cn.edu.tit.corejava.javagrammar;


/**
 * 抽象类和抽象方法
 * @author 李创博
 * @version: 1.0
 */
public class AbstractDemo {
	public static void main(String[] args) {
//	    Person person = new Person();//编译报错
		Person p = new Student("xiaozhang");
		Student s = new Student("xiaoming");
		s.eat();
	}
}

abstract class Person {
	/**
	 * 用途：一个类中没有包含足够的信息来描绘一个具体的对象时定义
	 * 注意事项：
	 * 	1.抽象类中可以做普通类能做的，如定义成员变量，成员方法，构造方法，实现接口，继承类等；
	 * 	2.抽象类不能实例化(注定要被继承)，只能通过实现类创建对象；
	 *  3.抽象方法必须放在抽象类中，但抽象类中可以没有抽象方法；
	 *  4.抽象类的子类必须实现它所有的抽象方法(编译不通过，除非抽象类子类也是抽象类)；
	 *  5.抽象类不能被实例化，可以按照多态的方式由具体的子类去实例化
	 * 在JDK8以前，抽象类方法的默认访问权限为protected
	 * 在JDK8以后，----------------- 为(default)
	 * 模板模式应用
	 */
	String name;
	public Person(String name) {
		this.name = name;
	}
	
	public abstract void eat();
	/**
	 * 抽象方法：
	 *  1.修饰符只能是protected/public(默认),否则不能通过编译
	 *  2.抽象方法没有方法体
	 *  3.abstract不能与private、static、final或native并列修饰同一个方法。
	 */
	
}

class Student extends Person {

	public Student(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println("吃米饭");
	}

}