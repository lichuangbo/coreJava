/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月8日
 */
package cn.edu.tit.corejava.day02;

import java.util.Scanner;

/**
 * bilibili 2019面试题：反转链表
 * 题目：
 * 		用户输入一行数据并以逗号分隔，先将数据存储到链表中，并以一定的规律翻转输出
 * 		如：输入1, 2, 3, 4, 5			输出1, 5, 2, 4, 3(a1, an, a2, an-1...)
 * @author 李创博
 * @version: 1.3
 */
public class Main{
    public static void main(String []args){   
    	/** 
    	 * 解决思路：
    	 * 	循环翻转，每次减少一个节点
    	 * 1,2,3,4,5
    	 * 1,5,4,3,2
    	 * 1,5,2,3,4
    	 * 1,5,2,4,3
    	 */
//    	String str = "";//测试数据
    	Scanner sc = new Scanner(System.in);
    	String str = sc.nextLine();
    	String []num = str.split(",");
    	ListNode node = pushNode(num);
//    	//注意：不能再次使用node，引用型变量会操作同一个链表
    	ListNode resNode = pushNode(num);
    	resNode.next = null;
    	
    	ListNode result = calcResult(node, resNode);
    	ListNode.showNode(result);
    }
    
    //利用传递过来的链表，计算结果node原链表，resNode链表用来组合结果
    public static ListNode calcResult(ListNode node, ListNode resNode) {  	
    	if (node.next == null) {
			return node;
		}
    	ListNode cur = resNode;
    	ListNode tempNode = null;
    	while(node.next.next != null) {
    		ListNode revNode = reverseNode(node.next);
    		//将反转后的链表首元素取出，接着存储并用cur指针进行链接
    		tempNode = new ListNode(revNode.val);
    		cur.next = tempNode;
    		cur = cur.next;
    		//重置node，使它进行下一次翻转
    		node = revNode;
    	}
    	//收尾工作，处理最后一次剩下的节点
    	tempNode = new ListNode(node.next.val);
    	tempNode.next = null;
    	cur.next = tempNode;
    	return resNode;
    }
    
    //将从node节点开始之后的节点全部反转
    public static ListNode reverseNode(ListNode node) {
    	/**
    	 * 1,2,3,4,5
    	 * 5,4,3,2
    	 * 2,3,4
    	 * 4,3
    	 */
    	if (node.next == null) {
			return node;
		}
    	ListNode prev = node;
	    ListNode cur = prev.next;
	    ListNode tempNode = cur.next;
	    int count = 0;
	    while(cur != null) {
	    	count++;
	    	tempNode = cur.next;
	    	cur.next = prev;
	    	//第一次将最后的节点next指针置为null
	    	if (count == 1) {
				prev.next = null;
			}
	    	prev = cur;
	    	cur = tempNode;
	    }
	    return prev;
    }
    
    //将解析出来的数组使用链表存储
    public static ListNode pushNode(String []num) {
    	ListNode node0 = new ListNode(num[0]);
    	ListNode node1 = null;
    	if (num.length == 0) {//数组为空
    		return node1;
    	}
    	if (num.length == 1) {//数组只有一个元素
			node0.next = node1;
			return node0;
		}
    	ListNode curNode = node0;
    	for (int i = 1; i < num.length; i++) {
			node1 = new ListNode(num[i]);
			curNode.next = node1;
			curNode = node1;
		}
        node1.next = null;
    	return node0;
    }
}

class ListNode {
	String val;
	ListNode next;
	//构造方法，用来创建链表节点
	ListNode(String x) { 
		val = x; 
	}
	
	//遍历打印链表
	public static void showNode(ListNode node) {
		while(node.next != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		System.out.println(node.val);
	}
}
