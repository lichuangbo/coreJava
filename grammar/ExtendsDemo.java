/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月29日
 */
package cn.edu.tit.corejava.javagrammar;

/**
 * @author 李创博
 * @version: 1.0
 */
public class ExtendsDemo{
	public static void main(String[] args) {
		Son xiaozhang = new Son();
		System.out.println(xiaozhang.son_age);//son_age=10
		//子类不能访问父类的私有成员变量和方法
		System.out.println(xiaozhang.father_age);//father_age=35
//		System.out.println(xiaozhang.wifeName);//编译报错
		
		Father zhang = new Father(100);
		System.out.println(zhang.father_age);//father_age=35
		/**
		 * 1.直接访问成员变量/成员方法：
		 * 		对象.属性，看对象是哪个类的，优先访问此类中的成员变量，没有就往父类找
		 * 2.间接通过成员方法访问成员变量：
		 *  	看方法属于谁就优先使用，没有再向父类找
		 */
		System.out.println(xiaozhang.money);//110
		xiaozhang.methodF();//父亲有存款100元
		
		System.out.println("-----------");
		xiaozhang.showSelf();
	}
}

class Father {
	int father_age = 35;
	int money = 100;
	private String wifeName = "wang";
		
	public Father() {
		this(-100);
		/**
		 * this关键字与super类似
		 * 都可以调用构造方法，成员变量，成员方法，不同在于this调用本类的，super调用父类的
		 * 注意：
		 * super和this两种构造调用不能同时使用, 因为语句都要求只能有一个且必须放置在构造方法的第一条语句上
		 */
	}
	public Father(int money) {
		System.out.println("Father构造方法");
	}
	
	public void methodF() {
		System.out.println("父亲有存款" + money + "元");
	}
	
	void showSelf() {
		System.out.println("父亲今年35岁，有存款100元");
	}
}

//在Java语言中，不支持多继承，但支持多级继承
class Son extends Father{
	int son_age = 10;
	int money = 110;

	public Son() {
		/**
		 * 1.子类构造方法默认调用父类无参构造方法：	super()
		 * 2.子类构造方法可以使用super 调用父类有参构造方法
		 * 3.super语句只能有一个且必须放置在构造方法的第一条语句上
		 */
		super(110);
		System.out.println("Son构造方法");
	}
	public void methodS() {
		System.out.println("儿子有存款" + money + "元");
	}
	
	@Override
	public void showSelf() {
		int money = 120;
		System.out.println("儿子今年10岁，有存款110元");
		
		//继承关系中，同名变量的访问方式
		System.out.println(money);		//120，访问局部变量
		System.out.println(this.money);	//110，访问本类成员变量
		System.out.println(super.money);//100，访问父类成员变量
		//继承关系中，同名方法的访问方式：优先使用 调用对象本类中的方法
		/**
		 * 重写(Override):
		 * 	仅发生在继承关系中，要求方法名称一样，参数列表一样
		 * 重写方法时注意：
		 * 	1.返回值如果是简单数据类型，父类子类要一致；如果是引用数据类型，子类必须小于等于父类返回值范围。
		 * 	2.子类权限必须大于等于父类方法的的权限，public > protected > (default) > private
		 * 重载(Overload):
		 * 	要求方法名称一样，参数列表不一样，返回值无要求
		 */
	}
}