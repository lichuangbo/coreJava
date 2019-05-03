/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月3日
 */
package cn.edu.tit.leetcode;

/**
 * 字符串中的第一个唯一字符
 * @author 李创博
 * @version: 1.0
 */
public class FirstUniqChar {
	public int firstUniqChar(String s) {
		/**
		 * 哈希表原理：
		 * 	遍历字符串将字符出现次数存放在数组中，再根据字符找对应索引值为1的索引
		 * 测试耗时24ms
		 */
		int []temp = new int[26];
		for (int i = 0; i < s.length(); i++) {
			temp[s.charAt(i) - 'a'] += 1;
		}
		for (int i = 0; i < s.length(); i++) {
			if (temp[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
        return -1;
    }
	
	public int firstUniqChar2(String s) {
		/**
		 * 对方法一进行优化，charAt(i)寻找比chars[i]耗时大
		 * 测试耗时：13ms
		 */
		char []chars = s.toCharArray();
		int []temp = new int[26];
		for (int i = 0; i < chars.length; i++) {
			temp[chars[i] - 'a'] += 1;
		}
		for (int i = 0; i < chars.length; i++) {
			if (temp[chars[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
	
	public int firstUniqChar3(String s) {
		/**
		 * 利用indexOf和lastIndexOf，一正一反，相等返回两者最小值
		 * 很巧妙，不太好想到
		 */
		int index = -1;
        
        for (int i = 'a'; i <= 'z'; i++) {
            int index1 = s.indexOf(i);
            if(index1 > -1 && index1 == s.lastIndexOf(i)){
                index = (index == -1) ? index1 : Math.min(index,index1);
            }
        }
        
        return index;
	}
	
	public static void main(String[] args) {
		String s = "loveleetcode";
		FirstUniqChar fuc = new FirstUniqChar();
		System.out.println(fuc.firstUniqChar3(s));
		System.out.println(s.indexOf(101) + " " + s.lastIndexOf(101));
	}
}
