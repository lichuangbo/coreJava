/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月23日
 */
package cn.edu.tit.corejava.collection;

/**
 * @author 李创博
 * @version: 1.0
 */
public class Person {
	private String name;
	private int age;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/* 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @Title:person
	 * @param name
	 * @param age
	 */
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	/* 
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* 
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
