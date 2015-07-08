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
	
	private LinkedNode reverseLinkedList(LinkedNode list) {
		if(list != null) {
			LinkedNode link = list.next;
			if(link!=null) {
				reverseLinkedList(link);
				link.next = list;
			}
		}
		
		
		
		return list;
	}
	
	
	public static void main(String[] args) {
		LinkedOps op = new LinkedOps();
		LinkedNode li = op.buildLinkedList();
		op.reverseLinkedList(li);
		
		
	}
}
