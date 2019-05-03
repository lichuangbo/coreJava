/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月3日
 */
package cn.edu.tit.corejava.javagrammar;

/**
 * @author 李创博
 * @version: 1.0
 */
public class PolymoDemo {
	/**
	 * 多态：
	 * 		一个对象拥有多种形态(既是...也是...)，就叫多态性。多态在继承的前提下产生
	 * 使用多态的好处：
	 * 		无论右边new的时候换成哪个子类对象，等号左边调用方法都不会变化。
	 * 转型：
	 * 1.对象的的向上转型(多态的写法):
	 * 		父类名称 对象名 = new 子类名称();
	 * 	向上转型一定是安全的，创建了一个子类对象，并把他当作父类来看待
	 * 2.对象的的向下转型:
	 * 		子类名称 对象名 = (子类名称)父类对象;
	 * 	把父类对象还原为本来的子类对象
	 */
	public static void main(String[] args) {
		//多态语法规则
		showPolyRule();
		
		//向上向下转型
//		transform();
		
		//多态的作用
//		showPolyFunc();
	}
	
	private static void showPolyRule() {
		/**
		 * 访问成员变量：
		 * 	直接通过对象名称访问成员变量：看等号左边是谁就优先用谁，没有则向上找
		 * 	间接通过成员方法访问成员变量：看该方法属于谁优先用谁，没有则向上找
		 * 访问成员方法：
		 * 	看对象是哪个类的，优先用谁的方法，没有往上找
		 * 口诀：
		 * 	成员变量：编译看左边，运行还看左边
		 *	成员方法：编译看左边，运行看右边
		 */
		Animal cat = new Cat();
		System.out.println(cat.age);//0
//		cat.showAge();//0，子类没有覆盖重写
		cat.showAge();//3,子类覆盖重写
		
		cat.method();//"子类重写父类方法"
		cat.methodF();//"父类特有方法"
	}

	private static void transform() {
		Animal animal = new Cat();//猫向上转型成为动物
		animal.speak();
//		animal.catchMouse();//报错，转型之后不能再访问子类特有方法
		Cat cat = (Cat)animal;
		cat.catchMouse();//将转型后的对象还原
//		Dog dog = (Dog)cat;//运行报错，类型转换错误，对象在创建的时候是猫才能转换为猫
		
		//当不清楚一个父类引用的对象是什么子类时，要进行instanceof判断，避免程序出现异常
		//对象 instanceof 类名称	返回boolean值
		if (animal instanceof Dog) {
			Dog dog = (Dog)animal;
			dog.watchHouse();
		}
		if (animal instanceof Cat) {
			Cat cat2 = (Cat)animal;
			cat2.catchMouse();
		}
	}

	private static void showPolyFunc() {
		Animal cat = new Cat();
		Animal dog = new Dog();
		//左边的类名称统一了，不同的对象针对同一命令做出不同的动作
		cat.speak();
		dog.speak();
	}
}

abstract class Animal {
	int age = 0;
	public abstract void speak();
	public void showAge() {
		System.out.println(age);
	}
	
	public void method() {
		System.out.println("父类抽象方法");
	}
	
	public void methodF() {
		System.out.println("父类特有方法");
	}
}

class Cat extends Animal{
	int age = 3;

	@Override
	public void speak() {
		System.out.println("喵喵喵~");
	}
	
	public void catchMouse() {
		System.out.println("猫要抓老鼠");
	}
	
	//覆盖重写showAge方法
	@Override
	public void showAge() {
		System.out.println(age);
	}
	
	@Override
	public void method() {
		System.out.println("子类重写父类方法");
	}
	
	public void methodZ() {
		System.out.println("子类特有方法");
	}
}

class Dog extends Animal{
	int age = 4;
	
	@Override
	public void speak() {
		System.out.println("汪汪汪~");
	}
	
	public void watchHouse() {
		System.out.println("狗要看家");
	}
}