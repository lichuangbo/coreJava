/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月30日
 */
package cn.edu.tit.corejava.javagrammar;

/**
 * @author 李创博
 * @version: 1.0
 */
public class InnerClassDemo {
	/**
	 * 分类：
	 * 1.成员内部类
	 * 	内用外，随意访问；外用内，需要借助内部类对象
	 * 2.局部内部类(匿名内部类)
	 * 	定义在方法中的类,且只能在此方法中使用
	  *  定义类的权限修饰符：
	 * 	1.外部类：public / (default)
	 * 	2.成员内部类：public protected (default) private 
	 * 	3.局部内部类：什么都不写(不等价default)
	 * 含有内部类的字节码文件有两个，Body$Heart.class和 Body.class
	 */
	public static void main(String[] args) {
		/**
		 * 如何使用成员内部类
		 * 	1.间接：在外部类的方法中，使用到内部类(new对象，对象.方法)，通过主方法调用外部类的方法间接调用内部类方法。
		 * 	2.直接：通过特定对象创建公式直接创建对象，对象.方法
		 */
//		Body body = new Body();
//		body.methodA();
//		
//		System.out.println("--------------");
//		Body.Heart heart = new Body().new Heart();
//		heart.beat();
		
		//使用局部内部类
//		Body body2 = new Body();
//		body2.methodOuter();
		
		/**
		 * 如果接口的实现或者式父类的子类只需要使用唯一的一次，可以考虑使用匿名内部类  
		 */
		//匿名类，省略实现类/子类名称
		MyInterface obj = new MyInterface() {
			
			@Override
			public void methodA() {
				System.out.println("使用匿名内部类");
			}
		};
		obj.methodA();
		
		//匿名对象，省略匿名对象，一次只能调用一次方法
		new MyInterface() {
			
			@Override
			public void methodA() {
				System.out.println("使用匿名对象");
			}
		}.methodA();
	}
}

class Body {
	private String name = "外部类成员变量a";
	
	public void methodA() {
		System.out.println("外部类方法");
		Heart heart = new Heart();
		heart.beat();
	}
	
	public class Heart {
		private String name = "内部类成员变量b";
		public void beat() {
			String name = "局部变量c";
			System.out.println("内部类方法");
			//内部类当中，同名变量的访问
			System.out.println("我是" + name);			//访问c
			System.out.println("我是" + this.name);		//访问b
			System.out.println("我是" + Body.this.name);  //访问a
		}
	}
	
	public void methodOuter() {
		//定义局部内部类
		class Inner {
			//在局部内部类中，如果希望访问所有方法的局部变量，要么添加final关键字要么保证它不变
			//与局部变量的生命周期有关，会copy一份变量
			final int num = 1;

			public void methodInner() {
				System.out.println(num);
			}
		}
		
		Inner inner = new Inner();
		inner.methodInner();
	}
}
