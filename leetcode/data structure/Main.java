/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月7日
 */
package cn.edu.tit.corejava.day02;

import java.util.Scanner;

/**
 * @author 李创博
 * @version: 1.0
 */
public class Main{
    public static void main(String []args){   
    	// 1,2,3,4,5
    	/** 
    	 * 1,5,4,3,2
    	 * 1,5,2,3,4
    	 * 1,5,2,4,3
    	 */
//    	Scanner sc = new Scanner(System.in);
//    	String str = sc.nextLine();
    	String str = "1,2,3,4,5";
    	String []num = str.split(",");
    	ListNode node = pushNode(num);

    	ListNode resNode = pushNode(num);
    	resNode.next = null;
    	
    	ListNode result = calcResult(node, resNode);
    	
//    	ListNode.showNode(result);
    }
    
    //利用传递过来的链表，计算结果
    public static ListNode calcResult(ListNode node, ListNode resNode) {
    	ListNode cur = resNode;
    	ListNode tempNode = null;
    	while(node.next.next != null) {
    		ListNode revNode = reverseNode(node.next);
    		//将反转后的链表首元素取出，接着存储并用cur指针进行链接
    		tempNode = new ListNode(revNode.val);
    		cur.next = tempNode;
    		ListNode.showNode(cur);
    		cur = cur.next;
    		//重置node，使它进行下一次翻转g
    		node = revNode;
    	}
    	//收尾工作，处理最后一次剩下的节点
    	tempNode = new ListNode(node.next.val);
//    	tempNode.next = null;
    	cur.next = tempNode;
    	ListNode.showNode(cur);
    	return cur;
    }
    
    //将从node节点开始之后的节点全部反转
    public static ListNode reverseNode(ListNode node) {
    	/**
    	 * 1,2,3,4,5
    	 * 5,4,3,2
    	 * 2,3,4
    	 * 4,3
    	 */
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
	ListNode(String x) { 
		val = x; 
	}
	
	public static void showNode(ListNode node) {
		while(node.next != null) {
			System.out.print(node.val + ",");
			node = node.next;
		}
		System.out.println(node.val);
	}
}
