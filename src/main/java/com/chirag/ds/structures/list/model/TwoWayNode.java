package com.chirag.ds.structures.list.model;

import com.chirag.ds.model.BaseNode;

/**
 * This class represents model node for Single direction list
 * @param <T> Type of object contained by Node
 * @author Chirag 
 */
public class TwoWayNode<T> extends BaseNode<T> {

	private TwoWayNode<T> prev;
	private TwoWayNode<T> next;
	
	/**
	 * Default Constructor
	 * @param data Data object for Node
	 */
	public TwoWayNode() {
		super();
		this.data = null;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * Constructor with null next node
	 * @param data Data object for Node
	 */
	public TwoWayNode(T data) {
		super();
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * Constructor with all fields
	 * @param data Data object for Node
	 * @param next Pointer to next Node
	 * @param prev Pointer to previous Node
	 */
	public TwoWayNode(T data, TwoWayNode<T> next, TwoWayNode<T> prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * @return the prev
	 */
	public TwoWayNode<T> getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(TwoWayNode<T> prev) {
		this.prev = prev;
	}

	/**
	 * @return the next
	 */
	public TwoWayNode<T> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(TwoWayNode<T> next) {
		this.next = next;
	}
	
}
