/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月4日
 */
package cn.edu.tit.leetcode;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * @author 李创博
 * @version: 1.0
 */
public class Anagram {
	public boolean isAnagram(String s, String t) {
		/**
		 * 先对两个字符串转数组排序，然后遍历如果一个不一致即返回false;
		 * 测试用时：10ms
		 */
		char []s1 = s.toCharArray();
		char []t1 = t.toCharArray();
		if (s1.length != t1.length) {
			return false;
		}
		Arrays.sort(s1);
		Arrays.sort(t1);
		for (int i = 0; i < s1.length; i++) {
			if (s1[i] != t1[i]) {
				return false;
			}
		}
		return true;
    }
	
	public boolean isAnagram2(String s, String t) {
		/**
		 * 根据字母数目相同原则，为两个字符串分别设置26个计数器，之后比较数目，一处不相等返回false；
		 * 测试用时14ms
		 */
		if (s.length() != t.length()) {
			return false;
		}
		int[] sNum = new int[26];
		int[] tNum = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	    	sNum[s.charAt(i) - 'a']++;
	    }
	    for (int i = 0; i < t.length(); i++) {
	    	tNum[t.charAt(i) - 'a']++;
	    }
	    for (int i = 0; i < 26; i++) {
	    	if (sNum[i] != tNum[i]) {
	    		return false;
	    	}
		}
	    return true;
	}
	
	public boolean isAnagram3(String s, String t) {
		/**
		 * 对方法二的优化：使用数组s[i]效率更高，在一个数组上加减减少空间
		 * 测试耗时：5ms
		 */
		char []s1 = s.toCharArray();
		char []t1 = t.toCharArray();
		if (s1.length != t1.length) {
			return false;
		}
		int []temp = new int[26];
		for (int i = 0; i < s1.length; i++) {
			temp[s1[i] - 'a']++;
			temp[t1[i] - 'a']--;
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		Anagram anagram = new Anagram();
		System.out.println(anagram.isAnagram(s, t));
	}
}
