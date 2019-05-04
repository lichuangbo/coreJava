/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月4日
 */
package cn.edu.tit.leetcode;

/**
 * 验证回文字符串
 * @author 李创博
 * @version: 1.0
 */
public class Palindrome {
	public boolean isPalindrome(String s) {
		/**
		 * 先将字符串中非字母数字字符转化为空字符，之后遍历看头和尾元素是否相同，一个不同即返回false;
		 * 测试耗时：49ms
		 * 效率低的原因在于repaceAll本身需要遍历
		 */
		if (s == "") {
			return true;
		}
        String temp = s.toLowerCase();
        temp = temp.replaceAll("[^{a-z}{0-9}]", "");
        char []chars = temp.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
			if (chars[i] != chars[chars.length - 1 - i]) {
				return false;
			}
//        	System.out.print(chars[i]);
//        	System.out.println(chars[chars.length - 1 -i]);
		}
		return true;
    }
	
	public boolean isPalindrome2(String s) {
		/**
		 * 双指针：i指针从头开始遍历，j指针从尾开始遍历；如果有效则标记falg=1，无效继续下一个；
		 * 如果flag相等紧接着判断所指元素是否相等，不等返回false，相等重置flag并继续下一个
		 */
		s = s.toLowerCase();
        char[] a = s.toCharArray();
        int i = 0, j = a.length - 1;
        int flag1 = 0, flag2 = 0;
        while (i < j) {
            if ((a[i] >= 'a' && a[i] <= 'z') || (a[i] >= '0' && a[i] <= '9')) {
                flag1 = 1;
            } else {
                i++;
            }
            if ((a[j] >= 'a' && a[j] <= 'z') || (a[j] >= '0' && a[j] <= '9')) {
                flag2 = 1;
            } else {
                j--;
            }
            if (flag1 == 1 && flag2 == 1) {
                if (a[i] == a[j]) {
                    i++;
                    j--;
                    flag1=0;
                    flag2=0;
                } else {
                    return false;
                }
            }
        }
        return true;
	}
	
	public static void main(String[] args) {
		String s = "race a car";
		Palindrome p = new Palindrome();
		System.out.println(p.isPalindrome2(s));
	}
}
