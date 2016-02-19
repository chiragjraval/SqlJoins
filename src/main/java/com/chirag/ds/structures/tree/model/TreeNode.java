package com.chirag.ds.structures.tree.model;

import com.chirag.ds.model.BaseNode;

public class TreeNode<T> extends BaseNode<T> {
	
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	/**
	 * Default Constructor
	 * @param data Data object for Node
	 */
	public TreeNode() {
		super();
		this.data = null;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Constructor with null next node
	 * @param data Data object for root Node
	 */
	public TreeNode(T data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Constructor with all fields
	 * @param data Data object for root Node
	 * @param left Pointer to Left Child Node
	 * @param right Pointer to Right Child Node
	 */
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * @return the left
	 */
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	
}
