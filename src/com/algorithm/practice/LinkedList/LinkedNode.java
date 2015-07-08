package com.algorithm.practice.LinkedList;

public class LinkedNode {
	public LinkedNode next;
	public int value;
	
	public LinkedNode(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
