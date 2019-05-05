/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月5日
 */
package cn.edu.tit.leetcode;

/**
 * 实现strStr()
 * @author 李创博
 * @version: 1.0
 */
public class StrStr {
	public int strStr(String haystack, String needle) {
		int start = 0;
        while(start <= haystack.length() - needle.length()){
        	//如果首字符匹配上，接着往后比较
            int i1 = start, i2 = 0;
            while(i2 < needle.length() && haystack.charAt(i1) == needle.charAt(i2)){
                i1++;
                i2++;
            }
            if(i2 == needle.length()) 
            	return start;
            //首字符没匹配上或者是首字符匹配上但后续字符不匹配，继续循环
            start++;
        }
        return -1;
    }
	
	public int strStr2(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals(""))
            return 0;
        return haystack.indexOf(needle);
    }
	
	public static void main(String[] args) {
		StrStr ss = new StrStr();
		String haystack = "hlello";
		String needle = "ll";
		System.out.println(ss.strStr(haystack, needle));
	}
}
