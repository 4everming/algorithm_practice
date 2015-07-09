package com.algorithm.practice.Tree;
import com.algorithm.practice.Tree.TreeNode;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.ArrayDeque;
import java.util.Stack;

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
	
	
	public void visit(TreeNode tree) {
		System.out.println("Visit " + tree);
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
	
	public int treeWidth(TreeNode tree) {
		if(tree == null) {
			return 0;
		}
		
		LinkedBlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		queue.add(tree);
		int maxWidth = 1;
		int levelSize = 1;
		while(queue.size()>0) {
			levelSize = queue.size();
			while(levelSize>0) {
				TreeNode t = queue.remove();
				levelSize--;
				if(t.left!=null) {
					queue.add(t.left);
				}
				if(t.right!=null) {
					queue.add(t.right);
				}
			}
			maxWidth = Math.max(maxWidth, queue.size());  //queue.size is next level count.  maxWidth is max width util now.
		}
		
		return maxWidth;
		
	}
	
	
	
	//first root   recursion
	
	public void preVisit(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		visit(tree);
		preVisit(tree.left);
		preVisit(tree.right);
	}
	
	//middle root  recursion
	public void inVisit(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		inVisit(tree.left);
		visit(tree);
		inVisit(tree.right);
	}
	
	//last root recursion
	public void postVisit(TreeNode tree) {
		if(tree == null) {
			return ;
		}
		postVisit(tree.left);
		postVisit(tree.right);
		visit(tree);
	}
	
	//no recursion visit
	public void preVisit2(TreeNode tree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode itr = tree;
		stack.push(itr);
		while(itr!=null && !stack.empty()) {
			itr = stack.pop();
			visit(itr);
			if(itr.right!=null) {
				stack.push(itr.right);
			}
			if(itr.left!=null) {
				stack.push(itr.left);
			}
		}
	}
	
	
	public void inVisit2(TreeNode tree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode itr = tree;
		stack.push(itr);
		while(itr!=null && !stack.empty()) {
			itr = stack.pop();
			while(itr!=null) { //move to the most left leaf
				stack.push(itr);
				itr = itr.left;
			}
			
			if(!stack.empty()) {
				itr = stack.pop();
				visit(itr);
				stack.push(itr.right);
			}
		}
	}
	
	public void postVisit2(TreeNode tree) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> visitStack = new Stack<TreeNode>();
		if(tree!=null) {
			stack.push(tree);
		}
		while(!stack.empty()) {
			TreeNode t = stack.pop();
			visitStack.push(t);
			
			//The earlier put in stack, the later out of stack
			//Then the later put in visit stack, the earlier out of visitStack to visit
			
			//same to use 2 stacks to implement a queue
			if(t.left!=null) {
				stack.push(t.left);
			}
			
			if(t.right!=null) {
				stack.push(t.right);   
			}
		}
		
		while(!visitStack.empty()) {
			visit(visitStack.pop());
		}
		
	}
	
	
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
			visit(t);
			if(t.left != null) {
				queue.add(t.left);
			}
			if (t.right != null) {
				queue.add(t.right);
			}
		}
		
		
	}
	
	//invert tree   recursion
	public TreeNode invertTree(TreeNode tree) {
		
		if(tree == null) {
			return null;
		}
		
		TreeNode tmpNode = tree.left;
		tree.left = tree.right;
		tree.right = tmpNode;
		
		invertTree(tree.left);
		invertTree(tree.right);
		
		return tree;
	}
	
	
	//invert tree  non-recursion  like visit by level
	
	
	
	

	public static void main(String[] args) {
		TreeOps treeop = new TreeOps();
		TreeNode t = treeop.buildTree();
//		int depth = treeop.treeLength(t);
//		System.out.println("depth:" + depth);
		
//		treeop.invertTree(t);
		
//		System.out.println("Visit Tree by level: ");
//		treeop.levelVisit(t);
		
		System.out.println("Visit Tree: ");
//		treeop.preVisit(t);
//		treeop.preVisit2(t);
		
//		treeop.inVisit(t);
//		System.out.println("========================");
//		treeop.inVisit2(t);
		
		treeop.postVisit(t);
		System.out.println("========================");
		treeop.postVisit2(t);
		
		
//		treeop.treeWidth(t);
		return ;
	}
}
