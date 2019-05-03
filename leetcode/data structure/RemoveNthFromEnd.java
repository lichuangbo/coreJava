/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月3日
 */
package cn.edu.tit.leetcode;


/**
 * 删除链表的倒数第N个节点
 * @author 李创博
 * @version: 1.0
 */
public class RemoveNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		/**
		 * 思路：
		 * 		根据n来判断被删节点位置，首先确定链表节点总数，
		 * 	    之后根据(count-n)确定指针移动次数，删除，收尾时处理删头节点的情况。
		 * 测试耗时：2ms
		 */
		ListNode tempNode = head;
		//计算节点总个数
		int count = 1;
        while(tempNode.next != null) {
        	count++;
        	tempNode = tempNode.next;
        }
        tempNode = head;
        
        //删除
        if (n == count) {
			head = head.next;
		}else {
			//移动指针到要删除节点的前一个节点
			for (int i = 0; i < count - n - 1; i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
		}
		return head;
    }
	
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		/**
		 * 双指针法：
		 * 		先让快指针移动n,紧接着判断移动是否有效，之后快慢指针同时移动确定被删节点位置，删除
		 * 测试用时：2ms
		 */
		ListNode preNode = head;
	    ListNode curNode = head;
	    for (int i = 0; i < n; i++) {
	        curNode = curNode.next;
	    }
	    //n等于节点总数时，返回头结点的下一节点
	    if (curNode == null) {
	        return preNode.next;
	    }
	    //使用双指针移动来确定被删节点的前一节点位置
	    while (curNode.next != null) {
	        preNode = preNode.next;
	        curNode = curNode.next;
	    }
	    preNode.next = preNode.next.next;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		ListNode.showNode(node1);
		System.out.println();
		
		RemoveNthFromEnd rnfe = new RemoveNthFromEnd();
		node1 = rnfe.removeNthFromEnd2(node1, 5);
		ListNode.showNode(node1);
	}
}
