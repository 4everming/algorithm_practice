package com.algorithm.practice.Tree;
import com.algorithm.practice.Tree.TreeNode;

import java.util.concurrent.LinkedBlockingQueue;

public class TreeOps {
	
	private TreeNode root;
	
	TreeOps() {
		root = null;
	}
	
	
	/*
                               root
                          n1	      n2
                     n3           n7 	  n8
	                   n4               n9
	                  n5              n10 n11
	                    n6                
	
	
	*/
	
	private TreeNode buildTree() {
		root = new TreeNode("root");
		TreeNode node1 = new TreeNode("n1");
		TreeNode node2 = new TreeNode("n2");
		TreeNode node3 = new TreeNode("n3");
		TreeNode node4 = new TreeNode("n4");
		TreeNode node5 = new TreeNode("n5");
		TreeNode node6 = new TreeNode("n6");
		TreeNode node7 = new TreeNode("n7");
		TreeNode node8 = new TreeNode("n8");
		TreeNode node9 = new TreeNode("n9");
		TreeNode node10 = new TreeNode("n10");
		TreeNode node11 = new TreeNode("n11");
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node3.right = node4;
		node4.left = node5;
		node5.right = node6;
		node2.left = node7;
		node2.right = node8;
		node8.left = node9;
		node9.left = node10;
		node9.right = node11;
		
		return root;
	}
	
	
	//recursion
	public int treeLength(TreeNode tree) {
		if(tree == null) {
			return 0;
		}
		else {
			return Math.max(treeLength(tree.left), treeLength(tree.right)) + 1;
		}
		
	}
	
	
	//first root   recursion
	
	public void preVisit(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		System.out.println("Visit " + tree);
		preVisit(tree.left);
		preVisit(tree.right);
	}
	
	//middle root  recursion
	public void inVisit(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		preVisit(tree.left);
		System.out.println("Visit " + tree);
		preVisit(tree.right);
	}
	
	//last root recursion
	public void postVisit(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		preVisit(tree.left);
		preVisit(tree.right);
		System.out.println("Visit " + tree);
	}
	
	//TODO:
	//no recursion visit
	
	//by level visit
	public void levelVisit(TreeNode tree) {
		LinkedBlockingQueue<TreeNode>  queue = new LinkedBlockingQueue<TreeNode>();
		if(tree == null) {
			return ;
		}
		else {
			queue.add(tree);
		}
		while(!queue.isEmpty()) {
			TreeNode t = queue.remove();
			System.out.println("Visit " + t);
			if(t.left != null) {
				queue.add(t.left);
			}
			if (t.right != null) {
				queue.add(t.right);
			}
		}
		
		
	}
	
	
	//tree width
	

	public static void main(String[] args) {
		TreeOps treeop = new TreeOps();
		TreeNode t = treeop.buildTree();
		int depth = treeop.treeLength(t);
		
		System.out.println("depth:" + depth);
		
		System.out.println("Pre Visit Tree:");
		treeop.preVisit(t);
		
		System.out.println("Visit Tree by level: ");
		treeop.levelVisit(t);
		
		
		return ;
	}
}
