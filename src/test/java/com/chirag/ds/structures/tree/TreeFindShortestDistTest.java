package com.chirag.ds.structures.tree;

import com.chirag.ds.structures.tree.model.TreeNode;
import com.chirag.ds.structures.tree.util.TreeUtils;

public class TreeFindShortestDistTest
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
		
		printShortestDistBetween(tree, node2, node5);
		printShortestDistBetween(tree, node2, root10);
		printShortestDistBetween(tree, node2, node14);
		printShortestDistBetween(tree, node12, node14);
	}
	
	private static <T extends Comparable<T>> void printShortestDistBetween(Tree<T> tree, TreeNode<T> node1, TreeNode<T> node2)
	{
		int dist = TreeUtils.findShortestDistBetweenNodes(tree, node1, node2);
		System.out.println("Shortest Dist between " + node1.getData() + " and " + node2.getData() + " :: " + dist);
	}

}
