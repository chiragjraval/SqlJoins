package com.chirag.ds.structures.tree;

import com.chirag.ds.structures.tree.model.TreeNode;

public class Tree<T extends Comparable<T>> {

	private TreeNode<T> root;
	
	/**
	 * @return the root
	 */
	public TreeNode<T> getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	/**
	 * This method initializes a Tree with null Root 
	 */
	public Tree() {
		this.setRoot(null); 
	}
	
	/**
	 * This method initializes a Tree with Root containing passed object 
	 * @param obj Initial Root object
	 */
	public Tree(T obj) {
		this.setRoot(new TreeNode<T>(obj));
	}
	
	/**
	 * This method initializes a Tree with passed node as Root
	 * @param node TreeNode obj to set as Root
	 */
	public Tree(TreeNode<T> node) {
		this.setRoot(node);
	}
	
	
	public void printInOrder()
	{
		System.out.print("[");
		printInOrderUtil(root);
		System.out.print("]");
	}
	
	private void printInOrderUtil(TreeNode<T> node)
	{
		if(node==null)
			return;
		
		printInOrderUtil(node.getLeft());
		System.out.print(node.getData() + ", ");
		printInOrderUtil(node.getRight());
	}
	
	public void printPreOrder()
	{
		System.out.print("[");
		printPreOrderUtil(root);
		System.out.print("]");
	}
	
	private void printPreOrderUtil(TreeNode<T> node)
	{
		if(node==null)
			return;
		
		System.out.print(node.getData() + ", ");
		printPreOrderUtil(node.getLeft());
		printPreOrderUtil(node.getRight());
	}
	
	public void printPostOrder()
	{
		System.out.print("[");
		printPostOrderUtil(root);
		System.out.print("]");
	}
	
	private void printPostOrderUtil(TreeNode<T> node)
	{
		if(node==null)
			return;
		
		printPostOrderUtil(node.getLeft());
		printPostOrderUtil(node.getRight());
		System.out.print(node.getData() + ", ");
	}
}
