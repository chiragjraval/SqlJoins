package com.chirag.ds.structures.tree;

import com.chirag.ds.structures.tree.model.TreeNode;
import com.chirag.ds.structures.tree.util.TreeUtils;

public class TreeFindLcaTest
{
	public static void main(String[] args)
	{
		TreeNode<Integer> node2 = new TreeNode<Integer>(2);
		TreeNode<Integer> node5 = new TreeNode<Integer>(5);
		TreeNode<Integer> node3 = new TreeNode<Integer>(3, node2, node5);
		TreeNode<Integer> node14 = new TreeNode<Integer>(14);
		TreeNode<Integer> node12 = new TreeNode<Integer>(12, null, node14);
		TreeNode<Integer> root10 = new TreeNode<Integer>(10, node3, node12);
		Tree<Integer> tree = new Tree<Integer>(root10);
		
		printLCA(tree, 14, 12);
		printLCA(tree, 5, 12);
		printLCA(tree, 12, 5);
		printLCA(tree, 2, 5);
	}
	
	private static <T extends Comparable<T>> void printLCA(Tree<T> tree, T data1, T data2)
	{
		TreeNode<T> lca = TreeUtils.findLCA(tree, data1, data2);
		System.out.println("LCA for " + data1 + " and " + data2 + " :: " + (lca!=null ? lca.getData() : "NULL"));
	}

}
