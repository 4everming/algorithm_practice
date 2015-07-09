package com.algorithm.practice.LinkedList;

public class LinkedOps {

	private LinkedNode buildLinkedList() {
		LinkedNode node1 = new LinkedNode(0);
		LinkedNode node2 = new LinkedNode(1);
		LinkedNode node3 = new LinkedNode(2);
		LinkedNode node4 = new LinkedNode(4);
		LinkedNode node5 = new LinkedNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		return node1;
	}
	
	private void visitLinkedList(LinkedNode list) {
		while(list!=null) {
			System.out.println("visit " + list);
			list = list.next;
		}
	}
	
//	private LinkedNode reverseLinkedList(LinkedNode list) {
//		if(list != null) {
//			LinkedNode link = list.next;
//			if(link!=null) {
//				reverseLinkedList(link);
//				link.next = list;
//			}
//			
//		}
//		
//		return list;
//	}
//	
	//no recursion
	private LinkedNode reverseLinkedList(LinkedNode list) {
		LinkedNode pre = null;
		LinkedNode head = list;
		LinkedNode next = list.next;
		
		while(head!=null) {   //每次迭代，由head指向pre。然后pre head next顺序后移一位。 注意终止条件
			head.next = pre;
			pre = head;
			head = next;
			if(head!=null)
				next = head.next;
		}
		
	
		
		return pre; //终止状态时 pre指向了头
	}
	
	public static void main(String[] args) {
		LinkedOps op = new LinkedOps();
		LinkedNode li = op.buildLinkedList();
		li = op.reverseLinkedList(li);
		op.visitLinkedList(li);
		
		
	}
}
