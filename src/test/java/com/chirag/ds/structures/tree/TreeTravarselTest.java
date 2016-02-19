package com.chirag.ds.structures.tree;

import com.chirag.ds.structures.tree.model.TreeNode;

public class TreeTravarselTest
{
	public static void main(String[] args)
	{
		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
		TreeNode<Integer> node5 = new TreeNode<Integer>(5);
		TreeNode<Integer> node3 = new TreeNode<Integer>(3, node2, node5);
		TreeNode<Integer> node14 = new TreeNode<Integer>(14);
		TreeNode<Integer> node12 = new TreeNode<Integer>(12, null, node14);
		TreeNode<Integer> root10 = new TreeNode<Integer>(10, node3, node12);
		Tree<Integer> tree10 = new Tree<Integer>(root10); 
		
		tree10.printInOrder();
		tree10.printPreOrder();
		tree10.printPostOrder();
	}
	

}
