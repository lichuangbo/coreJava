/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年4月23日
 */
package cn.edu.tit.corejava.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 李创博
 * @version: 1.0
 */
public class MapDemo {
	
	public static void main(String[] args) {
//		showMap();
		
//		showHashMap();
		
		showLinkedHashMap();
	}
	
	public static void showMap() {
		/**java.util.Map<k, v>接口
		 * 	1.Collection中的集合是单列集合，Map中集合是双列集合。
		 * 	2.Map中的集合键不可重复，值可重复，且键对应唯一的值。
		 * 	3.key和value的数据类型可以相同可以不同(都可以为空)
		 * 方法：
		 * 	V put(K key, V value):key值不重复，返回null；key值重复，value替换旧值，并返回旧值。
		 *  V remove(Object key):key存在，返回对应value;不存在，返回null;
		 *  V get(Object key)
		 *  boolean containsValue(Object value)
		 *  boolean containsKey(Object key)
		 *  int size() 
		 *  void clear()  
		 *  boolean isEmpty()   
		 *  Set<K> keySet():把Map集合中的key取出并存储到set集合中，之后再根据key寻找对应的value;
		 *  Set<Map.Entry<K,V>> entrySet():把map集合中的Entry对象取出并放置到Set集合中；
		 */
		Map<String, String> map = new HashMap<>();
		
		String v1 = map.put("aaa", "111");
		System.out.println(v1);
		String v2 = map.put("aaa", null);
		System.out.println(v2);
		map.put("bbb", "222");
		map.put("ccc", "333");
		System.out.println(map);
		
		String v3 = map.remove("ccc");
		System.out.println(v3);
		
		String v4 = map.get("bbb");
		System.out.println(v4);
		
		Boolean b5 = map.containsKey("bbb");
		Boolean b6 = map.containsValue("222");
		int n7 = map.size();
		System.out.println(b5 +""+ b6 + n7);
		
//		map.clear();
//		System.out.println(map.isEmpty());
		
		//遍历map集合(keySet):方法一
		Set<String> set = map.keySet();
		for (String s : set) {
			String value = map.get(s);
			System.out.println(s + "=" + value);
		}
		//遍历map集合(entrySet)：方法二
		Set<Map.Entry<String, String>> set2 = map.entrySet();
		Iterator<Map.Entry<String, String>> it = set2.iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
	
	public static void showHashMap() {
		/**
		 * HashMap的特点：(Map接口的实现类)
		 * 	1.HashMap的底层是哈希表，查询速度快
		 * 	2.HashMap集合是一个无序的集合，存储和取出的顺序可能不一致
		 * 注意：
		 * 	存储自定义类型时,为了key让唯一，要重写hashCode方法和equals方法
		 */
		HashMap<Person, String> map = new HashMap<>(1);
		map.put(new Person("小张", 21), "河北");
		map.put(new Person("小王", 23), "黑龙江");
		map.put(new Person("小张", 21), "河南");
		//不重写都会存放进去，重写完之后第一个value会被替代
		Set<Map.Entry<Person, String>> set = map.entrySet();
		for (Map.Entry<Person, String> entry : set) {
			System.out.println(entry.getKey() +"="+entry.getValue());
		}
	}
	
	public static void showLinkedHashMap() {
		/**
		 * LinkedHashMap特点：(继承自HashMap类)
		 * 	1.它底层是哈希表+链表(与LinkedHashSet类似的做法)
		 * 	2.它是有序的集合，存储和取出的顺序一致
		 */
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>(1);
		map.put("aaa", 111);
		map.put("ddd", 444);
		map.put("ccc", 333);
		map.put("ccc", 555);//不能存放key值重复的元素
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key +"="+value);
		}
	}

	public static void showHashTable() {
		/**
		 * HashTable(实现Map接口)：与HashTable类似，可被它取代
		 * 特点:
		 * 	1.底层是哈希表，单线程同步，速度慢
		 * 	2.不能存储null键和null值
		 */
	}
}

